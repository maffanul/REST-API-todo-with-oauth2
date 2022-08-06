DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE tbl_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(25) NOT NULL,
  password varchar(75) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tbl_note`;
CREATE TABLE tbl_note (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  note varchar(1000) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tbl_user(username,password)values ("dummy","$2a$10$ks24ZEIXccAk9rWTfuQHVu7knCkTvuj7OJl1RqCwCMnRfJNRGDglS");