# Table Setting

## store_tb

```sql
create table store_tb (
    id integer generated by default as identity,
    price integer,
    stock integer,
    name varchar(255),
    primary key (id)
);
```

## log_tb

```sql
create table log_tb (
    id integer generated by default as identity,
    storeId integer
    qty integer
    totalPrice integer
    buyer varchar(255),
    primary key (id)
);
```
