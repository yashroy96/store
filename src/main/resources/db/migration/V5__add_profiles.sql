CREATE TABLE profiles (
    id BIGINT PRIMARY KEY,
    bio TEXT,
    phone_number VARCHAR(15),
    date_of_birth DATE,
    loyalty_points INTEGER DEFAULT 0,
	    CONSTRAINT fk_user
        FOREIGN KEY (id)
        REFERENCES users(id)
);