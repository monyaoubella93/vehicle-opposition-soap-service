package local.verifopposition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "oppositions")
public class Opposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_immatriculation", unique = true, nullable = false)
    private String numeroImmatriculation;

    @Column(name = "en_opposition", nullable = false)
    private boolean enOpposition;

    @Column(name = "message", nullable = false)
    private String message;

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getNumeroImmatriculation() { 
        return numeroImmatriculation; 
    }
    public void setNumeroImmatriculation(String numeroImmatriculation) { 
        this.numeroImmatriculation = numeroImmatriculation; 
    }

    public boolean isEnOpposition() { 
        return enOpposition; 
    }
    public void setEnOpposition(boolean enOpposition) { 
        this.enOpposition = enOpposition; 
    }

    public String getMessage() { 
        return message; 
    }
    public void setMessage(String message) { 
        this.message = message; 
    }
}