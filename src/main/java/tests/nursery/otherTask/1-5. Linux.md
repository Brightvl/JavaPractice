# 1 часть задания в ubuntu 
1. Использование команды cat в Linux
	```bash
	cat > "model.register.pet.Pet" 
		собаки кошки хомяки
	cat > "Pack_animals" 
		лошади верблюды ослы
	cat model.register.pet.Pet Pack_animals > "Human_Friends"
 
	#ИТОГ:
	root@UbuntuVM:/home/brightvl/Nursery/Human_Friends
	```

2. Работа с директориями в Linux
	```bash
	mkdir animals
	mv Human_Friends animals

	#ИТОГ:
	root@UbuntuVM:/home/brightvl/Nursery/animals/Human_Friends
	```

3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”

	```bash
	apt-get install mysql-server
	```

4. Управление deb-пакетами
	```bash
	#установка
	#скачал репу с https://dev.mysql.com/downloads/repo/apt/
	dpkg -i mysql-apt-config_0.8.26-1_all.deb 
	apt update

	#удаление
	dpkg -l|grep mysql
	dpkg -r mysql-apt-config
	```

5. История
   ```bash
   history
    ```
   `Все задание описано выше, Сирота Ярослав Романович, дата сдачи до 4 ноября 2023, группа судя по всему 4335/4337, 
   так в
   ТГ указанно
   `

