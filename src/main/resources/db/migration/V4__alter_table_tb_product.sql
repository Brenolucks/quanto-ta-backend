ALTER TABLE tb_product
ADD COLUMN company_id BIGINT NOT NULL;

ALTER TABLE tb_product
ADD CONSTRAINT fk_product_company
FOREIGN KEY (company_id)
REFERENCES company (id);