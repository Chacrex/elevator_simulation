package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Factory;
import java.util.List;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.ICabine;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation.Ascenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation.Cabine;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation.Capteur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Implementation.Moteur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IAscenseur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.ICapteur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Ascenseur.Interface.IMoteur;
import fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.Systeme_de_Controle.Interface.ISysteme_de_Controle;

public class Factory_Ascenseur 
{
	public static IAscenseur CreerAscenseur(int NombreEtage, int vitesseMoteur, ISysteme_de_Controle controlSystem)
	{
		return new Ascenseur(NombreEtage, vitesseMoteur, controlSystem);
	}
	
	public static ICapteur CreerCapteur()
	{
		return new Capteur();
	}
	
	public static ICabine CreeCabine(ISysteme_de_Controle controlSystem, int vitesseMoteur)
	{
		return new Cabine(controlSystem, vitesseMoteur);
	}
	
	public static IMoteur CreeMoteur(int vitesseMoteur)
	{
		return new Moteur(vitesseMoteur);
	}
}


//List<ICapteur> capteurs, ICabine cabine, IMoteur moteur)
