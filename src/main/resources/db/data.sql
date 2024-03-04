-- INSERT INTO test.member (id, name) VALUES (1, 'name 1');
-- INSERT INTO test.member (id, name) VALUES (2, 'name 2');
-- INSERT INTO test.member (id, name) VALUES (3, 'name 3');
--
-- INSERT INTO test.article (title, content) VALUES ('제목 1', '내용 1');
-- INSERT INTO test.article (title, content) VALUES ('제목 2', '내용 2');
-- INSERT INTO test.article (title, content) VALUES ('제목 3', '내용 3');

INSERT INTO test.article (title, content, created_at, updated_at) VALUES ('제목 1', '내용 1', NOW(), NOW());
INSERT INTO test.article (title, content, created_at, updated_at) VALUES ('제목 2', '내용 2', NOW(), NOW());
INSERT INTO test.article (title, content, created_at, updated_at) VALUES ('제목 3', '내용 3', NOW(), NOW());