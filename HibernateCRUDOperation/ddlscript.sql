
    drop table if exists EmployeeInfo;

    create table EmployeeInfo (
        empNo integer not null,
        deptNo integer,
        empName varchar(255),
        empDesignation varchar(255),
        empSalary double precision,
        empJoiningDate datetime,
        primary key (empNo)
    );
