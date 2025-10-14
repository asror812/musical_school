CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO subjects (id, name, mode)
VALUES
    (1, 'piano', 'ALONE'),
    (2, 'classical singing', 'GROUP'),
    (3, 'music theory', 'GROUP');

INSERT INTO users (id, first_name, last_name, username, password, date_of_birth, role)
VALUES
  ('417fa06a-2737-4bf2-aa62-19f283119ede', 'John', 'Doe', 'john1', 'password', '2010-01-01', 'ADMIN'),
  ('945c6db6-49a1-4932-80cf-caa1435545a8', 'Alice', 'Smith', 'alice2', 'password', '2011-02-15', 'PUPIL'),
  ('575975ba-d1b8-43de-9214-50b864317820', 'Bob', 'Johnson', 'bob3', 'password', '2012-03-20', 'PUPIL'),
  ('cd91e0b8-04dc-4023-b35e-ed4c598b5fa2', 'Mary', 'Brown', 'mary4', 'password', '2010-04-10', 'PUPIL'),
  ('be334696-afac-43a8-b939-dc1f11533b75', 'James', 'Davis', 'james5', 'password', '2011-05-25', 'PUPIL'),

  ('8f0d50ca-f27e-42a3-b7df-9799bf5237f7', 'Olivia', 'Moore', 'olivia10', 'password', '2010-10-11', 'TEACHER'),
  ('35305dd4-315c-4647-8129-8cf994048487', 'Asror', 'R', 'asror8', 'password', '2011-08-22', 'TEACHER'),
  ('825cc9f5-cf71-4240-af25-f5d192169713', 'Farhod', 'R', 'farhod9', 'password', '2012-09-09', 'TEACHER'),
  ('ca9645a9-3814-4439-ba61-5672a7326f58', 'Timur', 'T', 'timur10', 'password', '2010-10-11', 'TEACHER');

INSERT INTO pupils (id) VALUES
('575975ba-d1b8-43de-9214-50b864317820'),
('945c6db6-49a1-4932-80cf-caa1435545a8'),
('cd91e0b8-04dc-4023-b35e-ed4c598b5fa2'),
('be334696-afac-43a8-b939-dc1f11533b75');

INSERT INTO teachers (id, phone_number) VALUES
('825cc9f5-cf71-4240-af25-f5d192169713', '97 675-08-12'),
('8f0d50ca-f27e-42a3-b7df-9799bf5237f7', '99 555-55-55'),
('35305dd4-315c-4647-8129-8cf994048487', '12 122-12-12'),
('ca9645a9-3814-4439-ba61-5672a7326f58', '90 900-00-00');



INSERT INTO lessons (teacher_id, subject_id, day_of_week, start_time, end_time) VALUES
-- MONDAY (4 lessons)
('8f0d50ca-f27e-42a3-b7df-9799bf5237f7', 1, 'MONDAY', '08:00:00', '09:00:00'),
('35305dd4-315c-4647-8129-8cf994048487', 2, 'MONDAY', '09:15:00', '10:15:00'),
('825cc9f5-cf71-4240-af25-f5d192169713', 3, 'MONDAY', '10:30:00', '11:30:00'),
('ca9645a9-3814-4439-ba61-5672a7326f58', 1, 'MONDAY', '11:45:00', '12:45:00'),

-- TUESDAY (3 lessons)
('35305dd4-315c-4647-8129-8cf994048487', 3, 'TUESDAY', '09:00:00', '10:00:00'),
('ca9645a9-3814-4439-ba61-5672a7326f58', 2, 'TUESDAY', '10:15:00', '11:15:00'),
('8f0d50ca-f27e-42a3-b7df-9799bf5237f7', 1, 'TUESDAY', '11:30:00', '12:30:00'),

-- WEDNESDAY (2 lessons)
('825cc9f5-cf71-4240-af25-f5d192169713', 1, 'WEDNESDAY', '08:30:00', '09:30:00'),
('ca9645a9-3814-4439-ba61-5672a7326f58', 3, 'WEDNESDAY', '09:45:00', '10:45:00'),

-- THURSDAY (4 lessons)
('8f0d50ca-f27e-42a3-b7df-9799bf5237f7', 2, 'THURSDAY', '08:00:00', '09:00:00'),
('35305dd4-315c-4647-8129-8cf994048487', 1, 'THURSDAY', '09:15:00', '10:15:00'),
('825cc9f5-cf71-4240-af25-f5d192169713', 2, 'THURSDAY', '10:30:00', '11:30:00'),
('ca9645a9-3814-4439-ba61-5672a7326f58', 3, 'THURSDAY', '11:45:00', '12:45:00'),

-- FRIDAY (3 lessons)
('35305dd4-315c-4647-8129-8cf994048487', 2, 'FRIDAY', '09:00:00', '10:00:00'),
('825cc9f5-cf71-4240-af25-f5d192169713', 3, 'FRIDAY', '10:15:00', '11:15:00'),
('ca9645a9-3814-4439-ba61-5672a7326f58', 1, 'FRIDAY', '11:30:00', '12:30:00'),

-- SATURDAY (2 lessons)
('8f0d50ca-f27e-42a3-b7df-9799bf5237f7', 3, 'SATURDAY', '08:30:00', '09:30:00'),
('35305dd4-315c-4647-8129-8cf994048487', 1, 'SATURDAY', '10:00:00', '11:00:00'),

-- SUNDAY (2 lessons)
('825cc9f5-cf71-4240-af25-f5d192169713', 2, 'SUNDAY', '08:00:00', '09:00:00'),
('ca9645a9-3814-4439-ba61-5672a7326f58', 1, 'SUNDAY', '09:15:00', '10:15:00');


SELECT * FROM  lessons