maven-archetype-webapp

Exercice 1 : Ajouter un entité nommé 'ProductCategory'

Créez une nouvelle classe ProductCategory dans.

Cette entité doit représenter une catégorie de produits et contenir les attributs suivants :
 - id : Identifiant unique (Long).
 - code : Code unique de la catégorie (String).
 - libelle : Description de la catégorie (String).
 - products : Collection de produits associés.

Configurez cette entité uniquement à l'aide du fichier orm.xml.
Aucun mapping par annotations n’est permis.
Modifiez la classe Product pour inclure la relation avec ProductCategory.