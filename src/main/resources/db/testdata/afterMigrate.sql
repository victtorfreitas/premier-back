-- Inserção de tipos de produtos
INSERT INTO public.tb_tipo_produto (id, nome, nome_plural)
VALUES (1, 'Camisa', 'Camisas');
INSERT INTO public.tb_tipo_produto (id, nome, nome_plural)
VALUES (2, 'Short', 'Shorts');
INSERT INTO public.tb_tipo_produto (id, nome, nome_plural)
VALUES (3, 'Boné', 'Bonés');
INSERT INTO public.tb_tipo_produto (id, nome, nome_plural)
VALUES (4, 'Sandália', 'Sandálias');

-- Inserção do estoque
INSERT INTO public.tb_estoque (id, nome, descricao, total)
VALUES (1, 'Palmas Shopping', 'loja segundo andar', null);
INSERT INTO public.tb_estoque (id, nome, descricao, total)
VALUES (2, 'Aureny IV', 'Matriz', null);

-- Inserção dos produtos
INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (1, null, 119.90, 3, 'Camisa de urso', 1, 1);
INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (2, null, 200.00, 5, 'Camisa de pato', 1, 1);
INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (3, null, 99.99, 2, 'Short de banana', 1, 2);
INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (4, null, 39.00, 10, 'Boné de estrela', 1, 3);
INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (5, null, 00.00, 0, 'Sandália', 1, 4);

INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (6, null, 00.00, 0, 'Camisa', 2, 1);
INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (7, null, 00.00, 0, 'Short', 2, 2);
INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (8, null, 00.00, 0, 'Boné', 2, 3);
INSERT INTO public.tb_produto (id, foto, preco, quantidade, descricao, estoque_id, tipo_id)
VALUES (9, null, 00.00, 0, 'Sandália', 2, 4);
