-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 30, 2009 at 02:16 PM
-- Server version: 5.1.37
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `csc480`
--

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`ACTIVITY_ID`, `NAME`) VALUES
(1, 'General Attendance'),
(2, 'Power Hour');

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EMPLOYEE_ID`, `PREFIX`, `FIRST_NAME`, `LAST_NAME`, `MIDDLE_NAME`, `NICK_NAME`, `SUFFIX`, `BIRTH_DT`, `SEX`, `ETHNICITY`, `HOME_PHONE`, `CELL_PHONE`, `WORK_PHONE`, `EMAIL`, `ADDRESS1`, `ADDRESS2`, `CITY`, `STATE`, `ZIP`, `TITLE`, `START_DT`, `TERMINATION_DT`) VALUES
(1, NULL, 'Stephen', 'Colletti', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, NULL, 'Norman', 'Hudnall', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, NULL, 'Wendy', 'Dilworth', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, NULL, 'Fred', 'Pham', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, NULL, 'Miriam', 'Langston', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, NULL, 'Blanca', 'Brochu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, NULL, 'Renee', 'Montoya', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`MEMBER_ID`, `PREFIX`, `FIRST_NAME`, `LAST_NAME`, `MIDDLE_NAME`, `NICK_NAME`, `SUFFIX`, `BIRTH_DT`, `SEX`, `ETHNICITY`, `HOME_PHONE`, `CELL_PHONE`, `WORK_PHONE`, `EMAIL`, `ADDRESS1`, `ADDRESS2`, `CITY`, `STATE`, `ZIP`, `START_DT`, `TERMINATION_DT`, `SCHOOL`, `GRADE_LEVEL`, `TEACHER`, `DOCTOR`, `DOCTOR_PHONE`, `INSURED`, `INSURANCE_GROUP_NUM`, `INSURANCE_MEMBER_NUM`, `PRIMARY_LANGUAGE`, `SINGLE_PARENT_HOUSEHOLD`, `MILITARY_CHILD`, `SITE_ID`) VALUES
(1, NULL, 'Jon', 'Hancock', NULL, 'Jon', NULL, '1994-10-14', 'M', 'Caucasian', NULL, '(559) 731-3990', NULL, NULL, '325 N Arroyo St', '', 'Visalia', 'CA', '93292', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(2, NULL, 'Dan', 'Daniels', NULL, 'Dan', NULL, '1996-08-06', 'M', 'African-American', '(559) 443-2323', '(559) 438-3323', NULL, NULL, '224 E Plum', '', 'Exeter', 'CA', '93221', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(3, NULL, 'George', 'Stevens', NULL, 'Georgie', NULL, '1993-02-02', 'M', 'Multi-Racial', '(559) 882-3322', '(559) 288-2223', NULL, NULL, '3223 E Pine St', '', 'Exeter', 'CA', '93221', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(4, NULL, 'Daniel', 'Stevens', NULL, 'Dan', NULL, '1996-10-05', 'M', 'Caucasian', '(559) 332-8288', '(559) 438-8382', NULL, NULL, '5987 E C St', '', 'Exeter', 'CA', '93221', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(5, NULL, 'Michael', 'Santibanez', NULL, '', NULL, '1997-04-06', 'M', 'Hispanic', '', '', NULL, NULL, '', '', '', '', '', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(6, NULL, 'Chan', 'Xai', NULL, '', NULL, '2000-09-05', 'F', 'Asian', '(559) 388-2283', '(559) 382-8112', NULL, NULL, '4432 E Pine St', '', 'Exeter', 'CA', '93221', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(7, NULL, 'Ashley', 'Marquez', NULL, 'Ash', NULL, '1999-12-05', 'F', 'Hispanic', '(559) 338-2223', '(559) 438-8823', NULL, NULL, '334 W Cedar St', '', 'Exeter', 'CA', '93221', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(8, NULL, 'Greg', 'Collins', NULL, 'Greggy', NULL, '2000-10-12', 'M', 'Caucasian', '', '', NULL, NULL, '322 E Burton Ave', '', 'Exeter', 'CA', '93221', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(9, NULL, 'Steven', 'Stark', NULL, '', NULL, '1997-01-05', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-16', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', NULL),
(10, NULL, 'Alana', 'Corce', NULL, '', NULL, '2000-12-12', 'F', 'African-American', '(559) 182-7362', '(559) 833-6273', NULL, NULL, '1763 W Alpine St', '', 'Exeter', 'CA', '93221', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 2),
(11, NULL, 'Cody', 'Fulop', NULL, '', NULL, '1996-02-16', 'M', 'Multi-Racial', '(559) 118-2227', '(559) 448-2232', NULL, NULL, '3224 W Pine St', '', 'Exeter', 'CA', '93221', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(12, NULL, 'Jessie', 'Orosz', NULL, '', NULL, '1995-11-12', 'M', 'Hispanic', '(559) 338-2232', '(559) 008-3323', NULL, NULL, '42272 Ave 460', '', 'Exeter', 'CA', '93221', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(13, NULL, 'Javier', 'Modzelewski', NULL, 'Jack', NULL, '2001-05-14', 'M', 'Multi-Racial', '(559) 118-2283', '(559) 228-1121', NULL, NULL, '4327 W Cedar St', '', 'Exeter', 'CA', '93221', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(14, NULL, 'Darren', 'Styers', NULL, '', NULL, '2001-09-30', 'M', 'Caucasian', '(599) 334-2243', '(559) 338-2232', NULL, NULL, '8763 S Visalia Rd', '', 'Exeter', 'CA', '93221', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(15, NULL, 'Neil', 'Taormina', NULL, '', NULL, '1995-09-04', 'M', 'Hispanic', '(559) 332-3323', '(559) 837-2232', NULL, NULL, '5773 W Pine St', '', 'Exeter', 'CA', '93221', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(16, NULL, 'Darren', 'Vandeusen', NULL, '', NULL, '1995-12-04', 'M', 'Caucasian', '(559) 327-3323', '(559) 338-2232', NULL, NULL, '132 E Walnut Ave', '', 'Exeter', 'CA', '93221', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(17, NULL, 'Max', 'Wiedemann', NULL, '', NULL, '1997-09-14', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(18, NULL, 'Lonnie', 'Beier', NULL, '', NULL, '1995-08-09', 'F', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(19, NULL, 'Penelope', 'Bartolo', NULL, 'Penny', NULL, '2000-03-12', 'F', 'Multi-Racial', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(20, NULL, 'Allan', 'Putney', NULL, '', NULL, '2000-05-12', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(21, NULL, 'Melisa', 'Ammann', NULL, '', NULL, '2002-02-02', 'M', 'Multi-Racial', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(22, NULL, 'Katherine', 'Wier', NULL, 'Katy', NULL, '1998-07-30', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(23, NULL, 'Kurt', 'Mirabito', NULL, '', NULL, '2000-12-22', 'M', 'Hispanic', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(24, NULL, 'Odessa', 'Downie', NULL, '', NULL, '2001-09-22', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(25, NULL, 'Tameka', 'Loughman', NULL, 'Tammy', NULL, '1998-03-06', 'F', 'African-American', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(26, NULL, 'Melody', 'Tello', NULL, '', NULL, '2001-03-15', 'F', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(27, NULL, 'Henry', 'Rembert', NULL, 'Hank', NULL, '1997-02-28', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(28, NULL, 'Jeremy', 'Mathis', NULL, '', NULL, '2001-08-09', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(29, NULL, 'Philip', 'Frith', NULL, '', NULL, '1998-04-22', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(30, NULL, 'Matthew', 'Castleman', NULL, 'Matt', NULL, '1998-03-29', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(31, NULL, 'Nicholas', 'Paulsen', NULL, 'Nick', NULL, '2000-03-12', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(32, NULL, 'Karen', 'Lemaster', NULL, '', NULL, '2000-05-22', 'F', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(33, NULL, 'Frank', 'Kinlaw', NULL, '', NULL, '2001-03-16', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1),
(34, NULL, 'Robert', 'Tibbs', NULL, 'Bobby', NULL, '1998-07-12', 'M', 'Caucasian', '', '', NULL, NULL, '', '', '', '', '', '2009-10-30', NULL, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, b'0', b'0', 1);

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`SITE_ID`, `NAME`) VALUES
(1, 'Exeter Pine'),
(2, 'Exeter Wilson');

--
-- Dumping data for table `userdetail`
--

INSERT INTO `userdetail` (`ID`, `USERNAME`, `PASSWORD`, `FIRSTNAME`, `LASTNAME`, `ENABLED`, `EMAIL`, `CREATED`, `REGION`, `EMPLOYEE_ID`) VALUES
(2, 'stephen.colletti', '50bfb9eaba79c506da12d6c83c83bcf0814d3bd9dd3d7a5e1661d593ab70006c', 'Stephen', 'Colletti', 1, 'stephen.colletti@bgcsequoias.org', '2009-10-30 14:03:59', NULL, NULL),
(3, 'norman.hudnall', '934cfbcd51db6d88f736824b62b0ff923a1eba50efd86307a91c335efd89466f', 'Norman', 'Hudnall', 1, 'norman.hudnall@bgcsequoias.org', '2009-10-30 14:04:28', NULL, NULL),
(4, 'wendy.Dilworth', '2023c572d346f910d8d202f16d1f50e66f287ad830fa65121123e4a78b4c59dc', 'Wendy', 'Dilworth', 0, 'wendy.dilworth@bgcsequoias.org', '2009-10-30 14:05:00', NULL, NULL),
(5, 'fred.pham', 'c0da733d4db987bbb0951fb14257e52efd2d3b28a6cc2076a9a00432067a1976', 'Fred', 'Pham', 1, 'fred.pham@bgcsequoias.org', '2009-10-30 14:05:34', NULL, NULL),
(6, 'miriam.langston', '476882f41c5df6d424ba58d68dc531546d8fd671155e12505e8c46026ea2d8c8', 'Miriam', 'Langston', 0, 'miriam.langston@bgcsequoias.org', '2009-10-30 14:06:03', NULL, NULL),
(7, 'blanca.brochu', 'e3d3abc69019676bbfe0a9a08410c2ab2df6d178170f64e3ed00ea2e87742c40', 'Blanca', 'Brochu', 1, 'blanca.brochu@bgcsequoias.org', '2009-10-30 14:06:32', NULL, NULL),
(9, 'renee.montoya', '9c69381649e3965ed3c1cf6310073a9aae8d0edc67013fb1d5ff072c2fd91ed1', 'Renee', 'Montoya', 1, 'renee.montoya@bgcsequoias.org', '2009-10-30 14:07:15', NULL, NULL);

--
-- Dumping data for table `userdetail_authority`
--

INSERT INTO `userdetail_authority` (`ID`, `AUTHORITY`, `CREATED`, `USERDETAIL_ID`) VALUES
(2, 'ROLE_SUPERVISOR', '2009-10-30 14:03:35', 2),
(3, 'ROLE_SUPERVISOR', '2009-10-30 14:04:04', 3),
(4, 'ROLE_SUPERVISOR', '2009-10-30 14:04:37', 4),
(5, 'ROLE_SUPERVISOR', '2009-10-30 14:05:10', 5),
(6, 'ROLE_SUPERVISOR', '2009-10-30 14:05:40', 6),
(7, 'ROLE_SUPERVISOR', '2009-10-30 14:06:08', 7),
(8, 'ROLE_SUPERVISOR', '2009-10-30 14:06:51', 9);
