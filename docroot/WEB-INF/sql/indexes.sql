create index IX_82DF7942 on library_LMSBook (bookTitle);
create index IX_550AA581 on library_LMSBook (bookTitle, author);
create index IX_81F0C397 on library_LMSBook (uuid_);

create index IX_C359775D on library_LMSBorrowing (bookId);

create index IX_82BAD206 on library_bookId (bookId);
create index IX_4068990A on library_bookId (borrowingId);