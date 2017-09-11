DROP TABLE IF EXISTS sbs_messages;
DROP TABLE IF EXISTS sbs_friends;
DROP TABLE IF EXISTS sbs_users;

CREATE TABLE sbs_users(id SERIAL UNIQUE NOT NULL,
				user_name VARCHAR(50) NOT NULL,
				user_email VARCHAR(50) UNIQUE NOT NULL,
				user_password VARCHAR(50) NOT NULL,
				PRIMARY KEY(id)
);

CREATE TABLE sbs_friends(id_user INTEGER REFERENCES sbs_users(id) ON DELETE CASCADE,
				id_friend INTEGER REFERENCES sbs_users(id) ON DELETE CASCADE
);

CREATE TABLE sbs_messages(id SERIAL UNIQUE NOT NULL,
				id_user INTEGER REFERENCES sbs_users(id) ON DELETE CASCADE,
				messageText VARCHAR(200) NOT NULL,
				PRIMARY KEY(id)
);

INSERT INTO sbs_users(id, user_name, user_email, user_password) VALUES (nextval('sbs_users_id_seq'), 'username', 'username@a5.com', 'admin');
INSERT INTO sbs_users(id, user_name, user_email, user_password) VALUES (nextval('sbs_users_id_seq'), 'username1', 'username1@a5.com', 'admin1');
INSERT INTO sbs_users(id, user_name, user_email, user_password) VALUES (nextval('sbs_users_id_seq'), 'username2', 'username2@a5.com', 'admin2');
INSERT INTO sbs_users(id, user_name, user_email, user_password) VALUES (nextval('sbs_users_id_seq'), 'username3', 'username3@a5.com', 'admin3');