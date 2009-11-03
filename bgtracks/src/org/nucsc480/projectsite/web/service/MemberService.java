package org.nucsc480.projectsite.web.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csc480.bgclub.domain.Member;
import org.csc480.bgclub.domain.Person.Sex;
import org.csc480.projectsite.web.data.BaseMessageResponse;
import org.csc480.projectsite.web.data.GridDataResponseMessage;
import org.csc480.projectsite.web.dataaccess.DataAccessPoint;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.eclipse.birt.data.engine.api.querydefn.SortDefinition;
import org.springframework.stereotype.Service;

@Service
@RemoteProxy
public class MemberService {

	protected final Log logger = LogFactory.getLog(getClass());

	@RemoteMethod
	public BaseMessageResponse deleteMember(int memberId, String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		logger.info("deleteMember was called");
		try {
			DataAccessPoint.getMemberManagerAccess().deleteMember(memberId);
			response.setValid(true);
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
		}

		return response;
	}

	@RemoteMethod
	public BaseMessageResponse addMember(Member member, String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		logger.info("addMember was called");
		try {
			member.setStartDt(new Date());
			member.setSex(member.getSexString().toLowerCase().startsWith("m") ? Sex.MALE : Sex.FEMALE);
			DataAccessPoint.getMemberManagerAccess().saveMember(member);
			response.setValid(true);
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
		}

		return response;
	}

	@RemoteMethod
	public BaseMessageResponse updateMember(Member member,
			String successDelegate) {
		BaseMessageResponse response = new BaseMessageResponse();
		response.setSuccessDelegate(successDelegate);
		logger.info("Update Member was called with a delegate of "
				+ successDelegate);
		logger.info("Sex of member is " + member.getSexString());
		member.setSex(member.getSexString().toLowerCase().startsWith("m") ? Sex.MALE : Sex.FEMALE);
		try {
			member.setStartDt(new Date());
			DataAccessPoint.getMemberManagerAccess().saveMember(member);
			response.setValid(true);
		} catch (Exception ex) {
			response.setMessage(ex.getMessage());
		}

		return response;
	}

	@RemoteMethod
	public GridDataResponseMessage loadMembers(int page, int rowsPer,
			String sortColumn, String sortDirection, String search) {
		logger.info("loadMembers was called");
		GridDataResponseMessage message = new GridDataResponseMessage();
		if(sortColumn.toLowerCase().trim().equals("sexstring")){
			sortColumn = "sex";
		}
		List<Member> rows = DataAccessPoint.getMemberManagerAccess()
				.getMemberByMatch(search, search, null, sortColumn,
						sortDirection);

		if (rows.size() > 0) {
			message.setTotal((int) Math.ceil((rows.size() * 1.0)
					/ (rowsPer * 1.0)));
		} else {
			message.setTotal(0);
		}
		message.setPage(page);
		if (message.getPage() > message.getTotal()) {
			message.setPage(message.getTotal());
		}

		message.setRecords(rows.size());
		if (rows.size() <= rowsPer) {
			message.setRows(rows);
		} else {
			int lower = (page - 1) * rowsPer;
			int upper = (((page - 1) + 1) * rowsPer);
			upper = upper >= rows.size() ? rows.size() : upper;
			message.setRows(rows.subList(lower, upper));
		}
		logger.info("Ceiling: " + Math.ceil(rows.size() / rowsPer));
		logger.info("Search: " + search);
		logger.info("Page: " + page);
		logger.info("Records: " + message.getRecords());
		logger.info("Total Records Returned: " + message.getRecords());
		return message;

	}

	@RemoteMethod
	public Member findMemberById(int id) {
		logger.info("findMember was called");
		return DataAccessPoint.getMemberManagerAccess().getMember(id);
	}

}
