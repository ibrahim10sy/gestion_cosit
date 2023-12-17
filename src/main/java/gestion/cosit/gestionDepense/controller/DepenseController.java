package gestion.cosit.gestionDepense.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import gestion.cosit.gestionDepense.model.Depense;
import gestion.cosit.gestionDepense.service.DepenseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Depenses")
public class DepenseController {

    @Autowired
    private DepenseService depenseService;

        @PostMapping("/create")
    @Operation(summary = "création de dépense")
    public ResponseEntity<Depense> createDepense(@Valid @RequestBody Depense depense) throws BadRequestException {
        return new ResponseEntity<>(depenseService.saveDepense(depense), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Modification d'un dépense")
    public ResponseEntity<Depense> updateDepenses(@Valid @RequestBody Depense depense, @PathVariable long id){
        return new ResponseEntity<>(depenseService.updateDepense(depense,id) , HttpStatus.OK);
    }
//    @PostMapping("/create")
//    @Operation(summary = "création de dépense")
//    public ResponseEntity<Depense> createDepense(
//            @Valid @RequestParam("depense") String depenses,
//            @RequestParam(value = "image" , required = false) MultipartFile multipartFile
//            ) throws Exception {
//        Depense depense1 = new Depense();
//        try {
//            depense1 = new JsonMapper().readValue(depenses , Depense.class);
//        }catch (JsonProcessingException e){
//            throw new Exception(e.getMessage());
//        }
//
//        Depense saveDepenses = depenseService.saveDepense(depense1, multipartFile);
//        return new ResponseEntity<>(saveDepenses, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    @Operation(summary = "Modification d'un dépense")
//    public ResponseEntity<Depense> updateDepense(
//            @Valid @RequestParam("depense") String depenses,
//            @PathVariable long id,
//            @RequestParam(value = "image" , required = false) MultipartFile multipartFile
//    ) throws Exception {
//        Depense depense1 = new Depense();
//        try {
//            depense1 = new JsonMapper().readValue(depenses , Depense.class);
//        }catch (JsonProcessingException e){
//            throw new Exception(e.getMessage());
//        }
//
//        Depense updateDepenses = depenseService.updateDepense(depense1,id, multipartFile);
//        return new ResponseEntity<>(updateDepenses, HttpStatus.CREATED);
//    }

    @GetMapping("/listDemandeByUser/{id}")
    @Operation(summary = "Affichage  des dépenses par en fonction des  demande")
    public ResponseEntity<List<Depense>> getAllDepenseByDemande(@PathVariable long id){
        return  new ResponseEntity<>(depenseService.allDepenseByIdDemande(id), HttpStatus.OK);
    }

    @GetMapping("/listDepenseByUser/{id}")
    @Operation(summary = "Affichage  des dépenses par en fonction de user")
    public ResponseEntity<List<Depense>> getAllDepenseByUser(@PathVariable long id){
        return  new ResponseEntity<>(depenseService.allDepenseByIdUtilisateur(id), HttpStatus.OK);
    }

    @GetMapping("/read")
    @Operation(summary = "Affichage  des dépenses par en fonction des  demande")
    public ResponseEntity<List<Depense>> getAllDepenseByDemande(){
        return  new ResponseEntity<>(depenseService.allDepense(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Suppression d'un dépense")
    public String deleteDepense(@PathVariable long id){
        return depenseService.deleteDepende(id);
    }
}


//    @PostMapping("/create")
//    @Operation(summary = "création de dépense")
//    public ResponseEntity<Depense> createDepense(@Valid @RequestBody Depense depense) throws BadRequestException {
//        return new ResponseEntity<>(depenseService.saveDepense(depense), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    @Operation(summary = "Modification d'un dépense")
//    public ResponseEntity<Depense> updateDepenses(@Valid @RequestBody Depense depense, @PathVariable long id){
//        return new ResponseEntity<>(depenseService.updateDepense(depense,id) , HttpStatus.OK);
//    }