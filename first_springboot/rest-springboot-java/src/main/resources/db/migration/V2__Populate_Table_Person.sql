LOCK TABLES `person` WRITE;
INSERT INTO `person` VALUES (1, 'Ayrton' ,'Senna'   ,'Sao Paulo'  ,'Male'),
							(2, 'Emanuel','Conte'   ,'Maringa'    ,'Male'),
							(3, 'Satoru' ,'Gojou'   ,'Tokyo'      ,'Male'),
							(5, 'Naruto' ,'Uzumaki' ,'Konoha Leaf','Male'),
							(6, 'Snoop'  ,'Dogg'    ,'Campton'    ,'Male'),
							(7, 'Nikola' ,'Tesla'   ,'Croatia'    ,'Male'),
							(8, 'Lady'   ,'Gaga'    ,'USA'        ,'Female'),
							(9, 'Gisele' ,'Bundchen','Gramado'    ,'Female'),
							(10,'Sakura' ,'Haruno'  ,'Konoha Leaf','Female');

UNLOCK TABLES;

