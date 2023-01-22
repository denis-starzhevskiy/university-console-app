insert into department (department_name, head_of_department)
values ('Перший' ,'Андрій Петрович'),
       ('Другий' ,'Євген петрович'),
       ('Третій' ,'Юрій Петрович'),
       ('Четвертий' ,'Андрій Петрович'),
       ('Пятий' ,'Богдан Петрович');

insert into lector (first_name, second_name, father_name, lector_degree, salary)
values
    ('Дмитро', 'Токар','Владиславович','ASSISTANT',1000),
    ('Денис','Горобець','Владимирович','ASSOCIATE_PROFESSOR',1700),
    ('Олег','Крадій','Владиславович','PROFESSOR',1000),
    ('Рома','Прешвидко','Владиславович','ASSOCIATE_PROFESSOR',3400),
    ('Кирил','Домашній','Владимирович','ASSISTANT',300),
    ('Діма','Вигоняйло','Владиславович','PROFESSOR',4000),
    ('Потап','Коріш','Владиславович','ASSOCIATE_PROFESSOR',8500);

insert into departments_lectors(department_id, lector_id)
values (1,3),
       (1,2),
       (2,4),
       (3,3),
       (3,5),
       (4,5),
       (4,3),
       (4,5),
       (5,7);

