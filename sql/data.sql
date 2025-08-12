INSERT INTO public.users (id, avatar_path, email, first_name, last_name, password, patronymic, registration_date, role) VALUES ('4f2b1775-4e33-42e1-b50d-cd014fe67d76', '/uploads/avatars/4f2b1775-4e33-42e1-b50d-cd014fe67d76.jpg', 'user@yy.ru', 'Иван', 'Иванов', 'user', 'Иванович', '2025-08-08 13:44:31.000000', 'ROLE_USER');
INSERT INTO public.users (id, avatar_path, email, first_name, last_name, password, patronymic, registration_date, role) VALUES ('7d13a99d-99d1-4756-94e5-59d0b7a577b7', '/uploads/avatars/7d13a99d-99d1-4756-94e5-59d0b7a577b7.jpg', 'admin@mm.ru', 'Петр', 'Петров', 'admin', 'Петрович', '2025-08-09 13:46:50.000000', 'ROLE_ADMIN');

INSERT INTO public.achievements (id, description, image_path, title) VALUES ('4f526ab2-0474-4e53-8114-bd2b15cbb9a2', 'Вы успешно завершили и оформили свой первый кейс!', '/uploads/achievements/4f526ab2-0474-4e53-8114-bd2b15cbb9a2.png', 'Первый кейс');
INSERT INTO public.achievements (id, description, image_path, title) VALUES ('09d04e73-6bfa-4036-878f-c47227e1fae3', 'Провели первый вебинар для коллег', '/uploads/achievements/09d04e73-6bfa-4036-878f-c47227e1fae3.png', 'Вебинарный дебют');
INSERT INTO public.achievements (id, description, image_path, title) VALUES ('aae0772b-0923-4c05-94e4-fe3934d04224', 'Организовали 5 вебинаров.', '/uploads/achievements/aae0772b-0923-4c05-94e4-fe3934d04224.png', 'Мастер обучения');
INSERT INTO public.achievements (id, description, image_path, title) VALUES ('bae43d65-21b4-44f0-8ea6-ae87a7d74e17', 'Создали 10 полезных кейсов', '/uploads/achievements/bae43d65-21b4-44f0-8ea6-ae87a7d74e17.png', 'Эксперт кейсов');
INSERT INTO public.achievements (id, description, image_path, title) VALUES ('bb70cddc-d3f6-4b3d-a61b-eba8544ffdb0', 'Провели 20 вебинаров и оформили 30 кейсов!', '/uploads/achievements/bb70cddc-d3f6-4b3d-a61b-eba8544ffdb0.png', 'Легенда роста');

INSERT INTO public.tasks (id, description, name) VALUES ('a19538a5-5721-48e1-a006-89f91fa46884', 'Проведение вебинаров для сотрудников', 'Вебинары');
INSERT INTO public.tasks (id, description, name) VALUES ('09456683-26b3-42ea-a724-f936b8fd54e6', 'Количество выполненных кейсов', 'Кейсы');

INSERT INTO public.categories (id, description, name) VALUES ('ae9979a8-7330-4d89-9850-458f619e3a0f', 'Для начинающих сотрудников компании', 'Новички');
INSERT INTO public.categories (id, description, name) VALUES ('83f6f10e-07fd-4ec4-877a-caf8dc76a919', 'Для опытных сотрудников', 'Эксперты');
INSERT INTO public.categories (id, description, name) VALUES ('6048ae75-4f1d-4ee7-934b-2dde2a78e2bc', 'Для самых опытных сотрудников', 'Легенды');

INSERT INTO public.user_task (id, current_progress, task_id, user_id) VALUES ('c5030dca-b50d-4e20-81ac-3bdccf3a3c6d', 0, 'a19538a5-5721-48e1-a006-89f91fa46884', '4f2b1775-4e33-42e1-b50d-cd014fe67d76');
INSERT INTO public.user_task (id, current_progress, task_id, user_id) VALUES ('e762da04-d66b-46f5-aca1-175c2c568ab9', 0, '09456683-26b3-42ea-a724-f936b8fd54e6', '4f2b1775-4e33-42e1-b50d-cd014fe67d76');
INSERT INTO public.user_task (id, current_progress, task_id, user_id) VALUES ('7a3eb226-c646-47bc-87ce-8b70c82181ab', 2, 'a19538a5-5721-48e1-a006-89f91fa46884', '7d13a99d-99d1-4756-94e5-59d0b7a577b7');
INSERT INTO public.user_task (id, current_progress, task_id, user_id) VALUES ('1de433e5-a073-458f-a615-7a041eb64fb8', 2, '09456683-26b3-42ea-a724-f936b8fd54e6', '7d13a99d-99d1-4756-94e5-59d0b7a577b7');

INSERT INTO public.user_achievement (id, completed_at, achievement_id, user_id) VALUES ('d44681fd-f1d8-4e11-ae91-95c90c22469e', '2025-08-11 14:00:30.000000', '4f526ab2-0474-4e53-8114-bd2b15cbb9a2', '7d13a99d-99d1-4756-94e5-59d0b7a577b7');
INSERT INTO public.user_achievement (id, completed_at, achievement_id, user_id) VALUES ('f6b68eda-91cb-46d7-a354-c2308d399855', '2025-08-10 14:00:43.000000', '09d04e73-6bfa-4036-878f-c47227e1fae3', '7d13a99d-99d1-4756-94e5-59d0b7a577b7');

INSERT INTO public.achievement_task (id, required_progress, achievement_id, task_id) VALUES ('63f3b4c6-b8fc-4d4e-ab30-483f2c9c485e', 1, '4f526ab2-0474-4e53-8114-bd2b15cbb9a2', '09456683-26b3-42ea-a724-f936b8fd54e6');
INSERT INTO public.achievement_task (id, required_progress, achievement_id, task_id) VALUES ('ccfd296e-e9df-4818-9d6b-bd259c72439b', 1, '09d04e73-6bfa-4036-878f-c47227e1fae3', 'a19538a5-5721-48e1-a006-89f91fa46884');
INSERT INTO public.achievement_task (id, required_progress, achievement_id, task_id) VALUES ('73880428-8aef-4690-b4a3-6e44fb50567c', 5, 'aae0772b-0923-4c05-94e4-fe3934d04224', 'a19538a5-5721-48e1-a006-89f91fa46884');
INSERT INTO public.achievement_task (id, required_progress, achievement_id, task_id) VALUES ('52efd421-090d-4935-9741-8106f4534836', 10, 'bae43d65-21b4-44f0-8ea6-ae87a7d74e17', '09456683-26b3-42ea-a724-f936b8fd54e6');
INSERT INTO public.achievement_task (id, required_progress, achievement_id, task_id) VALUES ('0ebe2035-9e32-4b7a-a12b-b63f85c331d1', 20, 'bb70cddc-d3f6-4b3d-a61b-eba8544ffdb0', 'a19538a5-5721-48e1-a006-89f91fa46884');
INSERT INTO public.achievement_task (id, required_progress, achievement_id, task_id) VALUES ('d1ef3ec0-07c2-4e02-bda5-c65f4e572b96', 30, 'bb70cddc-d3f6-4b3d-a61b-eba8544ffdb0', '09456683-26b3-42ea-a724-f936b8fd54e6');

INSERT INTO public.achievement_category (id, achievement_id, category_id) VALUES ('38781abe-5675-4fd7-8322-9b6241323f94', '4f526ab2-0474-4e53-8114-bd2b15cbb9a2', 'ae9979a8-7330-4d89-9850-458f619e3a0f');
INSERT INTO public.achievement_category (id, achievement_id, category_id) VALUES ('9b544b4e-1a2f-4cf2-9209-6d458dba81a5', '09d04e73-6bfa-4036-878f-c47227e1fae3', '83f6f10e-07fd-4ec4-877a-caf8dc76a919');
INSERT INTO public.achievement_category (id, achievement_id, category_id) VALUES ('ee69ab79-df8b-453b-84ed-4c575673863c', 'aae0772b-0923-4c05-94e4-fe3934d04224', '83f6f10e-07fd-4ec4-877a-caf8dc76a919');
INSERT INTO public.achievement_category (id, achievement_id, category_id) VALUES ('902b71eb-0a36-46da-81de-5c1bca7755db', 'bae43d65-21b4-44f0-8ea6-ae87a7d74e17', '83f6f10e-07fd-4ec4-877a-caf8dc76a919');
INSERT INTO public.achievement_category (id, achievement_id, category_id) VALUES ('e70c5d54-7d9d-4622-af79-c957b6dadb6b', 'bb70cddc-d3f6-4b3d-a61b-eba8544ffdb0', '6048ae75-4f1d-4ee7-934b-2dde2a78e2bc');
