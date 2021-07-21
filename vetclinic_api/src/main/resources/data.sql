
insert into tb_animal (animal_id, data_nascimento, especie, nome, raca) values ( 1, '2018-01-05' ,'CANINO', 'julinha', 'Golden');
insert into tb_animal (animal_id, data_nascimento, especie, nome, raca) values ( 2, '2021-01-05' , 'CANINO', 'belinha', 'Poodle'); 
insert into tb_animal (animal_id, data_nascimento, especie, nome, raca) values ( 3, '2020-01-05' , 'CANINO', 'apollo', 'Labrador');
insert into tb_animal (animal_id, data_nascimento, especie, nome, raca) values ( 4, '2029-01-05' , 'FELINO', 'apollo', 'Per');


insert into tb_tutor ( id, email, nome,  telefone, animal_id ) values ( 1, 'pedro@meuamigopet.com.br', 'Pedro', '(00) 55345-5555', 1 );
insert into tb_tutor ( id, email, nome,  telefone, animal_id ) values ( 2, 'anne@meuamigopet.com.br', 'Anne',  '(00) 88888-0987', 2 );
insert into tb_tutor ( id, email, nome, telefone, animal_id ) values ( 3, 'joao@meuamigopet.com.br','Jo�o Henrique',  '(00) 33548-9988', 3 );
insert into tb_tutor ( id, email, nome,  telefone, animal_id ) values ( 4, 'maria@meuamigopet.com.br', 'Mariz',  '(00) 98654-9856', 4 );  
    
insert into tb_veterinario ( id, email, nome, telefone ) values ( 1, 'rafael@meuamigopet.com.br','Dr Rafael', '(00) 55345-5555' );
insert into tb_veterinario ( id, email, nome, telefone ) values ( 2, 'josy@meuamigopet.com.br', 'Dr Josy',  '(00) 55345-5555' );
insert into tb_veterinario ( id, email, nome, telefone ) values ( 3, 'alana@meuamigopet.com.br','Dr Alanna',  '(00) 55345-5555' );

insert into tb_consulta ( id_consulta, data_consulta, status, animal_id, veterinario_id ) values ( 1, '2021-01-05', 'REALIZADA', 1, 1 ); 
insert into tb_consulta ( id_consulta, data_consulta, status, animal_id, veterinario_id ) values ( 2, '2021-01-05', 'CANCELADA', 2, 1 );
insert into tb_consulta ( id_consulta, data_consulta, status, animal_id, veterinario_id ) values ( 3, '2021-01-05', 'REALIZADA', 3, 1 ); 



 

