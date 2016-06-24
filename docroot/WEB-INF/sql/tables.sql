create table library_LMSBook (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	bookTitle VARCHAR(75) null,
	author VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table library_LMSBorrowing (
	borrowingId LONG not null primary key,
	bookId LONG,
	memberId LONG,
	dateBorrowed DATE null,
	dateReturned DATE null
);

create table library_bookId (
	bookId LONG not null,
	borrowingId LONG not null,
	primary key (bookId, borrowingId)
);