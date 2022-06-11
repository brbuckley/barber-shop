ALTER TABLE city
    ADD FOREIGN KEY (state_id)
        REFERENCES state_table(id);
ALTER TABLE shop
    ADD FOREIGN KEY (city_id)
        REFERENCES city(id);
ALTER TABLE barber
    ADD FOREIGN KEY (shop_id)
        REFERENCES shop(id);
ALTER TABLE queue
    ADD FOREIGN KEY (barber_id)
        REFERENCES barber(id);

ALTER TABLE appointment
    ADD FOREIGN KEY (customer_id)
        REFERENCES customer(id);
ALTER TABLE appointment
    ADD FOREIGN KEY (barber_id)
        REFERENCES barber(id);
ALTER TABLE appointment
    ADD FOREIGN KEY (haircut_id)
        REFERENCES haircut(id);
ALTER TABLE appointment
    ADD FOREIGN KEY (payment_id)
        REFERENCES payment(id);
ALTER TABLE appointment
    ADD FOREIGN KEY (queue_id)
        REFERENCES queue(id);