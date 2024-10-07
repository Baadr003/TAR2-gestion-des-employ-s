package entreprises;

import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.beans.Personne;
import ma.projet.services.DeveloppeurService;
import ma.projet.services.ManagerService;

public class Entreprises {
    public static void main(String[] args) {
        ManagerService managerService = new ManagerService();
        DeveloppeurService devService = new DeveloppeurService();

        // Créer deux développeurs
        Developpeur dev1 = new Developpeur("Dev1", 50000);
        Developpeur dev2 = new Developpeur("Dev2", 55000);
        devService.create(dev1);
        devService.create(dev2);

        // Créer un manager qui gère les deux développeurs
        Manager manager = new Manager("Manager", 80000);
        manager.addEmp(dev1);
        manager.addEmp(dev2);
        managerService.create(manager);

        // Créer un 3ème développeur
        Developpeur dev3 = new Developpeur("Dev3", 52000);
        devService.create(dev3);

        // Créer un directeur général qui gère le manager et le 3ème employé
        Manager directeurGeneral = new Manager("Directeur", 100000);
        directeurGeneral.addEmp(manager);
        directeurGeneral.addEmp(dev3);
        managerService.create(directeurGeneral);

        // Afficher les noms et les salaires des employés de haut en bas de la hiérarchie
        afficherHierarchie(directeurGeneral, 0);
    }

   private static void afficherHierarchie(Personne p, int niveau) {
        String indent = "";
        for (int i = 0; i < niveau; i++) {
            indent += "  ";
        }
        System.out.println(indent + p.getNom() + " "  + " - Salaire: " + p.getSalaire());
        if (p instanceof Manager) {
            Manager m = (Manager) p;
            for (int i = 0; i < m.getEmp().size(); i++) {
                Personne subordonne = m.getEmp().get(i);
                afficherHierarchie(subordonne, niveau + 1);
            }
        }
    }
}