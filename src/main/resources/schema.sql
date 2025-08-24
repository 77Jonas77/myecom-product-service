CREATE TABLE products.products
(
    product_id    UUID         NOT NULL,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    product_title VARCHAR(255) NOT NULL,
    image_url     VARCHAR(255) NOT NULL,
    price_unit    DECIMAL      NOT NULL,
    quantity      INTEGER      NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (product_id)
);