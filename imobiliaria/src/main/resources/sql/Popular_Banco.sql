INSERT INTO uf (nome, sigla) VALUES ('Acre', 'AC');
INSERT INTO uf (nome, sigla) VALUES ('Alagoas', 'AL');
INSERT INTO uf (nome, sigla) VALUES ('Amapá', 'AP');
INSERT INTO uf (nome, sigla) VALUES ('Amazonas', 'AM');
INSERT INTO uf (nome, sigla) VALUES ('Bahia', 'BA');
INSERT INTO uf (nome, sigla) VALUES ('Ceará', 'CE');
INSERT INTO uf (nome, sigla) VALUES ('Distrito Federal', 'DF');
INSERT INTO uf (nome, sigla) VALUES ('Espírito Santo', 'ES');
INSERT INTO uf (nome, sigla) VALUES ('Goiás', 'GO');
INSERT INTO uf (nome, sigla) VALUES ('Maranhão', 'MA');
INSERT INTO uf (nome, sigla) VALUES ('Mato Grosso', 'MT');
INSERT INTO uf (nome, sigla) VALUES ('Mato Grosso do Sul', 'MS');
INSERT INTO uf (nome, sigla) VALUES ('Minas Gerais', 'MG');
INSERT INTO uf (nome, sigla) VALUES ('Pará ', 'PA');
INSERT INTO uf (nome, sigla) VALUES ('Paraíba', 'PB');
INSERT INTO uf (nome, sigla) VALUES ('Paraná', 'PR');
INSERT INTO uf (nome, sigla) VALUES ('Pernambuco', 'PE');
INSERT INTO uf (nome, sigla) VALUES ('Piauí', 'PI');
INSERT INTO uf (nome, sigla) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO uf (nome, sigla) VALUES ('Rio Grande do Norte', 'RN');
INSERT INTO uf (nome, sigla) VALUES ('Rio Grande do Sul', 'RS');
INSERT INTO uf (nome, sigla) VALUES ('Rondônia', 'RO');
INSERT INTO uf (nome, sigla) VALUES ('Roraima', 'RR');
INSERT INTO uf (nome, sigla) VALUES ('Santa Catarina', 'SC');
INSERT INTO uf (nome, sigla) VALUES ('São Paulo', 'SP');
INSERT INTO uf (nome, sigla) VALUES ('Sergipe', 'SE');
INSERT INTO uf (nome, sigla) VALUES ('Tocantins', 'TO');

INSERT INTO cidade (nome, uf_id) VALUES ('Porto Alegre', 21);
INSERT INTO cidade (nome, uf_id) VALUES ('Florianópolis', 24);
INSERT INTO cidade (nome, uf_id) VALUES ('Curitiba', 16);
INSERT INTO cidade (nome, uf_id) VALUES ('São Paulo', 25);

INSERT INTO bairro (nome, cidade_id) VALUES ('Centro', 1);
INSERT INTO bairro (nome, cidade_id) VALUES ('Rio Branco', 1);
INSERT INTO bairro (nome, cidade_id) VALUES ('Cidade Baixa', 1);
INSERT INTO bairro (nome, cidade_id) VALUES ('São João', 1);
INSERT INTO bairro (nome, cidade_id) VALUES ('Jardim Botânico', 1);
INSERT INTO bairro (nome, cidade_id) VALUES ('Petrólopis', 1);
INSERT INTO bairro (nome, cidade_id) VALUES ('Centro', 2);
INSERT INTO bairro (nome, cidade_id) VALUES ('Jurerê Internacional', 2);
INSERT INTO bairro (nome, cidade_id) VALUES ('Estreito', 2);
INSERT INTO bairro (nome, cidade_id) VALUES ('Ingleses', 2);
INSERT INTO bairro (nome, cidade_id) VALUES ('Capoeiras', 2);
INSERT INTO bairro (nome, cidade_id) VALUES ('Campeche', 2);
INSERT INTO bairro (nome, cidade_id) VALUES ('Centro', 3);
INSERT INTO bairro (nome, cidade_id) VALUES ('Água Verde', 3);
INSERT INTO bairro (nome, cidade_id) VALUES ('Babel', 3);
INSERT INTO bairro (nome, cidade_id) VALUES ('Alto da Glória', 3);
INSERT INTO bairro (nome, cidade_id) VALUES ('Jardim Botânico', 3);
INSERT INTO bairro (nome, cidade_id) VALUES ('Cristo Rei', 3);
INSERT INTO bairro (nome, cidade_id) VALUES ('Centro', 4);
INSERT INTO bairro (nome, cidade_id) VALUES ('Vila Mariana', 4);
INSERT INTO bairro (nome, cidade_id) VALUES ('Jardins', 4);
INSERT INTO bairro (nome, cidade_id) VALUES ('Campo Grande', 4);
INSERT INTO bairro (nome, cidade_id) VALUES ('Vila Olímpia', 4);
INSERT INTO bairro (nome, cidade_id) VALUES ('Jardim Paulista', 4);

INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (60, 2, 1, TRUE, 'APARTAMENTO', 11);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (40, 1, 1, TRUE, 'APARTAMENTO', 1);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (30, 1, 1, TRUE, 'JK', 21);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (88, 3, 1, TRUE, 'APARTAMENTO', 13);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (100, 2, 2, FALSE, 'CASA', 17);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (33, 1, 1, TRUE, 'JK', 3);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (180, 0, 0, FALSE, 'TERRENO', 4);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (66, 2, 1, TRUE, 'APARTAMENTO', 7);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (75, 2, 1, TRUE, 'APARTAMENTO', 22);
INSERT INTO imovel (area_total, quartos, banheiros, condominio, tipo_imovel, bairro_id) VALUES (45, 1, 1, TRUE, 'APARTAMENTO', 12);

INSERT INTO venda (valor, imovel_id) VALUES (150000.00, 1);
INSERT INTO venda (valor, imovel_id) VALUES (100000.00, 2);
INSERT INTO venda (valor, imovel_id) VALUES (99000.00, 3);
INSERT INTO venda (valor, imovel_id) VALUES (145000.00, 4);
INSERT INTO venda (valor, imovel_id) VALUES (180000.00, 5);
INSERT INTO venda (valor, imovel_id) VALUES (122000.00, 6);






