package bestplacesinsouthernItaly;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bestplaces")
public class BestPlacesController {
	
	@Autowired
	private BestPlacesRepository bestPlacesRepository; 

    
   @GetMapping("/places")
    public List<BestPlaces> getAllPlaces() {
    	return bestPlacesRepository.findAll(); 
    	}
    	
    	@GetMapping("/place/{id}")
    	public BestPlaces getBookById(@PathVariable Long id) {
            return bestPlacesRepository.findById(id)
            		.orElseThrow(() -> new RuntimeException( id + "this id didn't find"));
            }
    
    
    @PostMapping("/save")
    public String savePlace(@RequestBody BestPlaces bestPlaces) {
		 bestPlacesRepository.save(bestPlaces);
		 return "Saved"; 
		}
    
    @PutMapping("/update/{id}")
    public String updatePlace(
    		@PathVariable Long id,
    		@RequestBody BestPlaces bestPlaces) {
    	
    	BestPlaces updatePlace = bestPlacesRepository.findById(id).get(); 
    	updatePlace.setName(bestPlaces.getName()); 
    	updatePlace.setRegion(bestPlaces.getRegion()); 
    	updatePlace.setType(bestPlaces.getType()); 
    	updatePlace.setCheap(bestPlaces.getCheap()); 
    	bestPlacesRepository.save(updatePlace); 
    	return "Updated"; 
    }
    
    @DeleteMapping("/delete/{id}")
    public String deletePlace(@PathVariable Long id) {
    	
    	BestPlaces deletePlace = bestPlacesRepository.findById(id).get();
    	bestPlacesRepository.delete(deletePlace);
    	return "Delete id:" + id; 
    }
    
    }

