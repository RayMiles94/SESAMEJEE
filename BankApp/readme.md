create or replace user spring@localhost identified by '123456';
<br/>
grant all privileges on *.* to spring@localhost identified by '123456';
<br/>
create database bank;
<br/>
grant all privileges on bank.* to spring@localhost;
<br/>
