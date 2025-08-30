-- Insert users
INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com');
INSERT INTO users (name, email) VALUES ('Jane Smith', 'jane.smith@example.com');
INSERT INTO users (name, email) VALUES ('Peter Jones', 'peter.jones@example.com');

-- Insert tickets
INSERT INTO tickets (subject, description, priority, status, assignee_id, created_at)
VALUES ('Cannot login', 'I cannot login to the system.', 'HIGH', 'OPEN', 1, NOW());

INSERT INTO tickets (subject, description, priority, status, assignee_id, created_at)
VALUES ('Email not working', 'I am not receiving emails.', 'MEDIUM', 'IN_PROGRESS', 2, NOW());

INSERT INTO tickets (subject, description, priority, status, assignee_id, created_at, closed_at)
VALUES ('Printer not working', 'The printer on the second floor is not working.', 'LOW', 'CLOSED', 1, NOW(), NOW());
