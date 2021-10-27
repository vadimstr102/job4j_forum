insert into authorities (authority)
values ('ROLE_USER');

insert into authorities (authority)
values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('admin', true, '$2a$10$VjEYIBT59CIhaGV0BjUH1.SsAjZ078PYMyhzuF9GFD6nlTD2B8pk.',
        (select id from authorities where authority = 'ROLE_ADMIN'));
