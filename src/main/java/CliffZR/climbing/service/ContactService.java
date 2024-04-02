//package CliffZR.climbing.service;
//
//
//import CliffZR.climbing.models.BoulderingGrades;
//import CliffZR.climbing.repo.BoulderingGradeRepo;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Optional;
//import java.util.function.BiFunction;
//import java.util.function.Function;
//
//import static CliffZR.climbing.constant.Constant.PHOTO_DIRECTORY;
//import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
//
//@Service
//@Slf4j
//@Transactional(rollbackOn = Exception.class)
//@RequiredArgsConstructor
//public class ContactService {
//    private final BoulderingGradeRepo boulderingGradeRepo;
//
//    public Page<BoulderingGrades> getAllContacts(int page, int size) { //gets all contacts
//        return boulderingGradeRepo.findAll(PageRequest.of(page, size, Sort.by("title"))); // sorts by name
//    }
//
//    public BoulderingGrades getContact(String id){
//        return boulderingGradeRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found")); //finds single contact
//    }
//
//    public BoulderingGrades createContact(BoulderingGrades boulderingGrades){ // POST im assuming
//        return boulderingGradeRepo.save(boulderingGrades);
//    }
//
//    public String deleteContactById(String id){
//       if (boulderingGradeRepo.existsById(id)){
//           boulderingGradeRepo.deleteById((id));
//           return "Entity with " + id + " deleted successfully";
//       }
//       return "Entity with ID " + id + " not found";
//    }
//
//
//    public String uploadPhoto(String id, MultipartFile file){
//        BoulderingGrades boulderingGrades = getContact(id);
//        String photoUrl = photoFunction.apply(id, file);
//        boulderingGrades.setPhotoUrl(photoUrl);
//        boulderingGradeRepo.save(boulderingGrades);
//        return photoUrl;
//    }
//
//    private final Function<String, String> fileExtension = filename -> Optional.of(filename).filter(name -> name.contains("."))
//            .map(name -> "." + name.substring(filename.lastIndexOf(".") + 1)).orElse(".png");
//
//    private final BiFunction<String, MultipartFile, String> photoFunction = (id, image) -> {
//        String filename = id + fileExtension.apply(image.getOriginalFilename());
//        try {
//            Path fileStorageLocation = Paths.get(PHOTO_DIRECTORY).toAbsolutePath().normalize();
//            if(!Files.exists(fileStorageLocation)) { Files.createDirectories(fileStorageLocation); }
//            Files.copy(image.getInputStream(), fileStorageLocation.resolve(filename), REPLACE_EXISTING);
//            return ServletUriComponentsBuilder
//                    .fromCurrentContextPath()
//                    .path("/contacts/image/" + filename).toUriString();
//        }catch (Exception exception) {
//            throw new RuntimeException("Unable to save image");
//        }
//    };
////
//}
