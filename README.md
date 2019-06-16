# crud-jpql
JPQL - oriented programming query language for performing queries it is similar to SQL, 
but queries the entity model instead of tables and supports OOP notions like inheritance and polymorphism.

TypedQuery <Model> query = entityManager("SELECT model FROM Model model WHERE model.id =: id", Model.class);
