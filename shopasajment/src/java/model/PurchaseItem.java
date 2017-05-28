package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "purchase_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseItem.findAll", query = "SELECT p FROM PurchaseItem p"),
    @NamedQuery(name = "PurchaseItem.findById", query = "SELECT p FROM PurchaseItem p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseItem.findByPurchase", query = "SELECT p FROM PurchaseItem p WHERE p.purchase = :purchase"),
    @NamedQuery(name = "PurchaseItem.findByItem", query = "SELECT p FROM PurchaseItem p WHERE p.item = :item")})
public class PurchaseItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchase")
    private int purchase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item")
    private int item;

    public PurchaseItem() {
    }

    public PurchaseItem(Integer id) {
        this.id = id;
    }

    public PurchaseItem(int purchase, int item) {
        this.purchase = purchase;
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseItem)) {
            return false;
        }
        PurchaseItem other = (PurchaseItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PurchaseItem[ id=" + id + " ]";
    }

}
