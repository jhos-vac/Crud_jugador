CREATE TABLE IF NOT EXISTS advices(
    id SERIAL,
    player_id INT NOT NULL,
    date_match VARCHAR(20),
    meeting VARCHAR(100),
    color_card VARCHAR(20),
    PRIMARY KEY (id),
    FOREIGN KEY (player_id) REFERENCES player(id)
)
