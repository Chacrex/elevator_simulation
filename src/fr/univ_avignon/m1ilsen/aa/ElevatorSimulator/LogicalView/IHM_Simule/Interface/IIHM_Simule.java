package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface;

import java.util.List;

public interface IIHM_Simule {

	public void GererPortes(int get_position, boolean b);
	
	public int AffichageEtage();

	public void Descendre(int etage);
	public void Monter(int etage);
	public boolean GetEtatPorte(int etage);
	public void ChoixNiveau(int etageVoulu);
	
}
