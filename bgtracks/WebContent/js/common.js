function BaseSuccessDelegate(response) {
	if (response !== undefined && response !== null) {
		if (response.isValid === true) {
			window[response.successDelegate](response.data);
		} else {
			$.jGrowl(response.message, { sticky: true});
		}
	}
}