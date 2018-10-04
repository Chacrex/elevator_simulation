package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface;

public interface ICabine {
	public enum Etat_cabine{
		ouverte, fermee, en_mouvement
	}
	
	int get_position();
	void ouverture();
	Etat_cabine get_etat_cabine();
	void mise_en_mvt(IAscenseur.Sens sens);
	void fin_mvt();
}
