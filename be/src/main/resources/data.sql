INSERT INTO member (email, name, password, profile)
values ('nag@codesquad.kr', 'nag', '1q2w3e4r!',
        'https://source.boringavatars.com/beam/20/nag'),
       ('joy@codesquad.kr', 'joy', '1q2w3e4r!',
        'https://source.boringavatars.com/beam/20/joy'),
       ('ati@codesquad.kr', 'ati', '1q2w3e4r!',
        'https://source.boringavatars.com/beam/20/ati');

INSERT INTO milestone (name, due_date, is_open)
values ('마일스톤1', current_date, 1),
       ('마일스톤2', current_date, 0),INSERT INTO member (email, name, password, profile)
values ('nag@codesquad.kr', 'nag', '1q2w3e4r!',
    'https://source.boringavatars.com/beam/20/nag'),
    ('joy@codesquad.kr', 'joy', '1q2w3e4r!',
    'https://source.boringavatars.com/beam/20/joy'),
    ('ati@codesquad.kr', 'ati', '1q2w3e4r!',
    'https://source.boringavatars.com/beam/20/ati');

INSERT INTO milestone (name, due_date, is_open)
values ('마일스톤1', current_date, 1),
       ('마일스톤2', current_date, 0),
       ('마일스톤3', current_date, 1),
       ('마일스톤4', current_date, 0),
       ('마일스톤5', current_date, 1),
       ('마일스톤6', current_date, 1),
       ('마일스톤7', current_date, 0),
       ('마일스톤0', current_date, 1);

INSERT INTO label (name, background_color, text_color)
values ('라벨1', '#F08080', '#000000'),
       ('라벨2', '#98FB98', '#000000'),
       ('라벨3', '#6495ED', '#000000'),
       ('라벨4', '#00BFFF', '#000000'),
       ('라벨5', '#FFAFE6', '#000000'),
       ('라벨6', '#FFF56E', '#000000'),
       ('라벨7', '#32BEBE', '#000000'),
       ('라벨0', '#98FB98', '#000000');

INSERT INTO issue (author_id, milestone_id, title, is_open)
values (1, 1, '제목1', 1),
       (2, 2, '제목2', 0),
       (3, 3, '제목3', 1),
       (1, 3, '제목4', 1),
       (2, 3, '제목5', 1),
       (3, 3, '제목6', 1),
       (1, 4, '제목7', 1),
       (1, 4, '제목8', 0),
       (2, 3, '제목9', 1),
       (2, 7, '제목10', 0),
       (3, 7, '제목11', 1),
       (1, 5, '제목12', 1),
       (3, 3, '제목13', 0),
       (2, 6, '제목14', 1),
       (3, 1, '제목15', 1),
       (1, 6, '제목16', 0);

INSERT INTO issue_label (issue_id, label_id)
values (1, 1),
       (1, 2),
       (2, 3),
       (3, 1),
       (3, 3),
       (4, 1),
       (4, 2),
       (5, 1),
       (5, 2),
       (5, 3),
       (5, 4),
       (6, 6),
       (6, 7),
       (6, 1),
       (6, 3),
       (7, 1),
       (7, 2),
       (7, 4),
       (8, 1),
       (8, 5),
       (13, 2),
       (13, 3),
       (11, 3),
       (11, 5),
       (11, 5),
       (15, 3);

INSERT INTO issue_assignee (issue_id, assignee_id)
values (1, 1),
       (1, 2),
       (2, 3),
       (3, 1),
       (3, 3),
       (4, 1),
       (4, 2),
       (4, 3),
       (5, 1),
       (6, 1),
       (6, 2),
       (7, 1),
       (8, 1),
       (8, 3),
       (11, 3),
       (13, 2),
       (14, 1),
       (14, 2),
       (14, 3),
       (16, 1);

INSERT INTO comment (issue_id, author_id, contents)
values (1, 1, '1번 댓글입니다.'),
       (1, 2, '2번 댓글입니다.'),
       (1, 2, '3번 댓글입니다.'),
       (3, 1, '4번 댓글입니다.'),
       (4, 1, '5번 댓글입니다.'),
       (4, 1, '6번 댓글입니다.'),
       (4, 1, '7번 댓글입니다.'),
       (5, 2, '8번 댓글입니다.'),
       (5, 3, '9번 댓글입니다.'),
       (5, 1, '10번 댓글입니다.'),
       (5, 2, '11번 댓글입니다.');

('마일스톤3', current_date, 1),
       ('마일스톤0', current_date, 1);

INSERT INTO label (name, background_color, text_color)
values ('라벨1', '#F08080', '#000000'),
       ('라벨2', '#98FB98', '#000000'),
       ('라벨3', '#6495ED', '#000000'),
       ('라벨0', '#98FB98', '#000000');

INSERT INTO issue (author_id, milestone_id, title, is_open)
values (1, 1, '제목1', 1),
       (2, 2, '제목2', 0),
       (3, 3, '제목3', 1),
       (3, 1, '제목4', 0),
       (1, 1, '제목5', 0);

INSERT INTO issue_label (issue_id, label_id)
values (1, 1),
       (1, 2),
       (2, 3),
       (3, 1),
       (3, 3),
       (4, 1),
       (4, 2),
       (4, 3);

INSERT INTO issue_assignee (issue_id, assignee_id)
values (1, 1),
       (1, 2),
       (2, 3),
       (3, 1),
       (3, 3),
       (4, 1),
       (4, 2),
       (4, 3);

INSERT INTO comment (issue_id, author_id, contents)
values (1, 1, '1번 댓글입니다.'),
       (1, 2, '2번 댓글입니다.'),
       (1, 2, '3번 댓글입니다.'),
       (3, 1, '4번 댓글입니다.'),
       (4, 1, '5번 댓글입니다.'),
       (4, 1, '6번 댓글입니다.'),
       (4, 1, '7번 댓글입니다.'),
       (5, 2, '8번 댓글입니다.'),
       (5, 3, '9번 댓글입니다.'),
       (5, 1, '10번 댓글입니다.'),
       (5, 2, '11번 댓글입니다.');
