package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Implementation;

import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Gestionnaire_de_Simulation.Interface.IUtilisateur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface.IIHM_Simule;

public class Utilisateur implements IUtilisateur {
	
	int id;
	int niveauDepart;
	int niveauArrivee;
	// Temps en millisecondes avant la requête de l'utilisateur
	int debutAppel;
	boolean traitementReq;
	IIHM_Simule ihm;
	
	// Constructeur Utilisateur
	public Utilisateur(int id, int niveauDepart, int niveauArrivee, int debutAppel,  IIHM_Simule uneihm) {
		this.id = id;
		ihm = uneihm;
		traitementReq = false;
		this.niveauDepart = niveauDepart;
		this.niveauArrivee = niveauArrivee;
		this.debutAppel = debutAppel;
	}
	

	@Override
	public boolean get_traitementReq()
	{
		return traitementReq;
	}
	
	@Override
	public void TraitementFait()
	{
		traitementReq = true;
	}
	
	@Override
	public int get_id()
	{
		return id;
	}
	
	@Override
	public int get_debutAppel()
	{
		return debutAppel;
	}
	
	@Override
	public int get_niveauDepart()
	{
		return niveauDepart;
	}
	
	@Override
	public int get_niveauArrivee()
	{
		return niveauArrivee;
	}


	public void Monter()
	{
		
	}
	
	public void Descendre()
	{
		
	}
	
	@Override
	public void Requete() {
		if(niveauDepart < niveauArrivee) {
			ihm.Monter(niveauDepart);
		} else {
			ihm.Descendre(niveauDepart);
		}
	}

}
