CREATE TABLE IF NOT EXISTS users (name VARCHAR(255), email VARCHAR(255));

CREATE TABLE IF NOT EXISTS tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    priority ENUM('LOW', 'MEDIUM', 'HIGH') NOT NULL DEFAULT 'MEDIUM',
    status ENUM('OPEN', 'IN_PROGRESS', 'CLOSED') NOT NULL DEFAULT 'OPEN',
    assignee_id INT NULL,
    created_at DATETIME,
    closed_at DATETIME NULL
);

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
