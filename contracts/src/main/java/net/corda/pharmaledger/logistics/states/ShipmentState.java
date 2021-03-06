package net.corda.pharmaledger.logistics.states;

import java.util.ArrayList;
import java.util.List;

import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.AnonymousParty;
import net.corda.pharmaledger.logistics.contracts.ShipmentStateContract;

@BelongsToContract(ShipmentStateContract.class)
public class ShipmentState implements ContractState{
    private String packageID; 
    //currently using this state only for the view from pharma account
    private String status;
    private AnonymousParty fromLogistics;
    private AnonymousParty toPharma;
    private List<AbstractParty> participants;


    public ShipmentState(String packageID, String status, AnonymousParty fromLogistics, AnonymousParty toPharma) {
        this.packageID = packageID;
        this.status = status;
        this.fromLogistics = fromLogistics;
        this.toPharma = toPharma;
        this.participants = new ArrayList<AbstractParty>();
        this.participants.add(fromLogistics);
        this.participants.add(toPharma);
    }

    public String getpackageID() {
        return this.packageID;
    }

    public void setpackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AnonymousParty getFromLogistics() {
        return this.fromLogistics;
    }

    public void setFromLogistics(AnonymousParty fromLogistics) {
        this.fromLogistics = fromLogistics;
    }

    public AnonymousParty getToPharma() {
        return this.toPharma;
    }

    public void setToPharma(AnonymousParty toPharma) {
        this.toPharma = toPharma;
    }

    @Override
    public List<AbstractParty> getParticipants() {
        return this.participants;
    }

}
