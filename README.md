README - Gestion des employés
Description du Projet
Le projet "Gestion des employés" est une application de gestion des employés destinée à une petite entreprise comptant cinq employés. Elle implémente une structure hiérarchique permettant d'organiser les employés sous différents managers et d'effectuer des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur les données des employés. Le projet utilise une base de données MySQL pour la persistance des données.

Objectifs
Implémenter une structure hiérarchique d'entreprise.
Gérer les informations des employés, telles que les noms et les salaires.
Permettre les opérations CRUD sur les employés.
Utiliser une base de données pour stocker les informations relatives aux employés.
Fonctionnalités
Gestion des employés avec hiérarchie (Manager, Développeur, etc.).
CRUD (Créer, Lire, Mettre à jour, Supprimer) sur les employés.
Persistance des données dans une base MySQL.
Affichage de la hiérarchie organisationnelle.
Structure du Projet
1. Couche d'accès aux données
L'accès aux données est réalisé à l'aide d'un fichier de configuration (config.properties) qui contient les informations de connexion à la base de données MySQL. Une classe Connexion centralise l'ouverture de la connexion avec la base.

2. Gestion des employés
Deux principales classes, Manager et Développeur, héritent d'une classe mère Personne. Chaque employé, qu'il soit manager ou développeur, possède des attributs tels que l'ID, le nom et le salaire.

3. Interface IDao
Une interface générique IDao<T> est utilisée pour gérer les opérations CRUD. Elle est flexible et peut être adaptée à différents types d'employés (Manager, Développeur).

4. Services
Les services ManagerService et DeveloppeurService implémentent l'interface IDao<T>. Ils permettent de gérer les opérations CRUD pour les managers et les développeurs.

5. Tests et Hiérarchie
Une classe Entreprise permet de tester les opérations CRUD. Elle modélise également la hiérarchie des employés et propose une méthode pour afficher cette hiérarchie de manière claire.

Installation
Prérequis
Java 8 ou supérieur.
Serveur MySQL installé.
IDE Java (Eclipse, IntelliJ IDEA, etc.).
Étapes d'installation
Cloner le dépôt du projet :

bash
Copier le code
git clone https://github.com/username/gestion-employes.git
Configurer la base de données :

Créez une base de données MySQL nommée taf2.
Importez le fichier SQL fourni dans le dossier sql/ pour créer les tables manager et developpeur.
Configurer les propriétés de connexion :

Dans le fichier config.properties, renseignez les informations de connexion à votre base de données (URL, utilisateur, mot de passe).
Compiler et exécuter le projet :

Importez le projet dans votre IDE.
Compilez et exécutez les classes de test pour vérifier le bon fonctionnement des opérations CRUD.
Utilisation
L'application permet d'effectuer les opérations suivantes :

Ajouter un manager ou un développeur.
Mettre à jour les informations d'un employé.
Supprimer un employé de la base de données.
Afficher la hiérarchie complète des employés avec les relations manager-développeur.
Exemple de Hiérarchie
txt
Copier le code
Directeur Général
└── Manager 1
    └── Développeur 1
    └── Développeur 2
└── Manager 2
    └── Développeur 3
Auteurs
Badr Korichi - Développeur principal.
PR. Laachgar Mohammed - Encadrant académique.
