insert into user_details(id,birth_date,name,password)
values(101, current_date(), 'Vladimir', '1234');

insert into user_details(id,birth_date,name,password)
values(102, current_date(), 'Josh', 'qwerty');

insert into user_details(id,birth_date,name,password)
values(103, current_date(), 'Alex', 'my-password');


insert into post(id,description,user_id)
values(201, 'I will learn Java', 101);

insert into post(id,description,user_id)
values(202, 'We are working on a great project!', 101);

insert into post(id,description,user_id)
values(203, 'Currently debugging', 102);

insert into post(id,description,user_id)
values(204, 'I wanna go out tonight', 102);