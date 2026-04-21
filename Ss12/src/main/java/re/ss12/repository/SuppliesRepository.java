package re.ss12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import re.ss12.model.entity.Supplies;

import java.util.List;

@Repository
public interface SuppliesRepository extends JpaRepository<Supplies, Long> {
    //    ktra tồn tại theo mã vật tư
    boolean existsByCode(String code);

    //    tìm kiếm theo tên
    @Query("SELECT s FROM supplies s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Supplies> searchByName(@Param("name") String name);
}
