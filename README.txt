1) В проекте использовалась JAVA8 поэтому убедитесь что у вас она установлена и прописана в $JAVA_HOME
2) Проект запускаеться командой ' mvn spring-boot:run '
3) Настройки подключение БД указываються в файле /src/main/resources/application.properties (я использовал MySQL, если вы захотите заменить ее на какую небуть другую не забудьте поменять драйвер + dependency в pom.xml )
4) Таблица в БД создаеться на основании Entity (src/main/java/hello/Models/Contacts.java) при помощи hibernate (обращаю ваше внимание что application.properties hibernate.ddl-auto указан как сreate, поэтому при каждом запуске таблица в БД будет удаояться и создавать заново)
5) Для тестирования я записываю в БД 50 имен (запись происходит во врямя инициализации контроллера в методе afterPropertiesSet() )