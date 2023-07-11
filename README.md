# CRUD-DAO-design-
1) Student class - whole class object that needs to be mappped in database via ORM(through entity manager) and has constructor to populate its fields value.
2) StudentDAO--->StudentDAOImpl - It has entity manager which is injected via constructor . It also have save() method that takes Student object and save to db via EntityManager.
3)Main file-
commandLineRunner that accepts StudentDAO via DI injection as @Repository is used in StudentDAOImpl (annotation used for class that have db code and also it makes it a component i.e. bean for DI)
it has method that takes StudentDao and inside it it creates student object then DAO have save() method that will take this object and save it in db   
