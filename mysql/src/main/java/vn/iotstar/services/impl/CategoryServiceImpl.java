package vn.iotstar.services.impl
import java.util.List;
import java.util.Locale.Category;

import vn.iotstar.Dao.CategoryDao;
import vn.iotstar.Dao.impl.CategoryDaoImpl;
import vn.iotstar.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDAO = new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        if (category == null) return;
        categoryDAO.insert(category);
    }

    @Override
    public void edit(Category category) {
        if (category == null || category.getId() == null || category.getUserId() == null) return;
        categoryDAO.edit(category);
    }

    @Override
    public void delete(int id, Long userId) {
        if (userId == null) return;
        if (categoryDAO instanceof CategoryDaoImpl) {
            ((CategoryDaoImpl) categoryDAO).delete(id, userId);
        }
    }

    @Override
    public Category get(int id, Long userId) {
        if (userId == null) return null;
        if (categoryDAO instanceof CategoryDaoImpl) {
            return ((CategoryDaoImpl) categoryDAO).get(id, userId);
        }
        return null;
    }

    @Override
    public Category get(String name, Long userId) {
        if (userId == null) return null;
        if (categoryDAO instanceof CategoryDaoImpl) {
            return ((CategoryDaoImpl) categoryDAO).get(name, userId);
        }
        return null;
    }

    @Override
    public List<Category> getAllByUserId(Long userId) {
        if (userId == null) return List.of();
        return categoryDAO.getAllByUserId(userId);
    }

    @Override
    public List<Category> search(Long userId, String keyword) {
        if (userId == null) return List.of();
        if (categoryDAO instanceof CategoryDaoImpl) {
            return ((CategoryDaoImpl) categoryDAO).search(userId, keyword == null ? "" : keyword);
        }
        return List.of();
    }
}
