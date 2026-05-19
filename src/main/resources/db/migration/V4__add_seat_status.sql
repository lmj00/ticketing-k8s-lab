ALTER TABLE seat ADD COLUMN status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE';
ALTER TABLE seat ADD INDEX idx_seat_show_status (show_id, status);
