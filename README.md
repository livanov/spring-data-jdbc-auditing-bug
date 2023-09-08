# Spring Data JDBC scenario with unexpected behavior when auditing

## Purpose
To show an unexpected behavior with Spring Data JDBC when Auditing enabled

## Details
Spring Data JDBC with Auditing enabled can successfully save `@CreatedDate` details on aggregate root and one-to-one
entities, however on a one-to-many relationship auditing fails to assign `@CreatedDate` details. 
