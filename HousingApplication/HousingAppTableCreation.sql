create database HousingApplication;

create table Customer(
   customerId int auto_increment primary key,
   customerName varchar(30) not null,
   customerEmailId varchar(30) not null,
   customerMobileNo decimal(10) not null unique,
   propertyId int,
   foreign key(propertyId) references Property(propertyId) on delete set null
);
create table Property(
  propertyId int auto_increment primary key,
  propertyLocation varchar(50) not null,
  furnishedDetails varchar(50) not null,
  bhkDetails int not null,
  otherPropertyFacilities varchar(500) ,
  purposeOfProperty varchar(50) not null,
  priceOfProperty decimal(15,5) not null,
  propertyOwnerName varchar(50) not null,
  propertyOwnerMobileNo decimal(10,0) not null,
  bookingStatus varchar(30) not null default 'NotBooked'
);
