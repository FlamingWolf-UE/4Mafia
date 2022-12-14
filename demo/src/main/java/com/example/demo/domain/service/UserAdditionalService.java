package com.example.demo.domain.service;

import com.example.demo.domain.entityModel.PageModel;
import com.example.demo.domain.entityModel.RatingDataModel;
import com.example.demo.domain.entityModel.UserAdditionalModel;
import com.example.demo.domain.model.ClubRole;
import com.example.demo.domain.model.GameMember;
import com.example.demo.domain.model.UserAdditional;
import com.example.demo.domain.repository.ClubRoleRepository;
import com.example.demo.domain.repository.UserAdditionalRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserAdditionalService {
    @Autowired
    private final UserAdditionalRepository repository;
    @Autowired
    private final ClubRoleService ServiceC;

    public UserAdditionalService(UserAdditionalRepository UserAdditionalRepository, ClubRoleRepository repositoryC, ClubRoleService serviceC) {
        this.repository = UserAdditionalRepository;

        ServiceC = serviceC;
    }

    public Page<UserAdditional> getAll(Pageable pageable)
    {
        return repository.findAll(pageable);

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void add(@NotNull UserAdditional UserAdditional) throws Exception {
        if (repository.findById(UserAdditional.getId()).isEmpty())
            repository.save(UserAdditional);
        else
            throw new Exception(UserAdditional.class.getName() +" class entity with id " + UserAdditional.getId() + " is already exist");
    }

    public Optional<UserAdditional> getByID(Integer id)
    {
        return repository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, NoSuchElementException.class})
    public void deleteDetachedUser(Integer id) throws Exception {
        Optional<UserAdditional> user = repository.findById(id);
        if(user.isEmpty()) throw new NoSuchElementException();
        if(user.get().getMembers().isEmpty())
            repository.deleteById(id);
        else
            throw new Exception(UserAdditional.class.getName() +" class entity with id " + id + " is already attached to Game entity");
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void update(@NotNull UserAdditional UserAdditional) throws Exception {
        if (repository.findById(UserAdditional.getId()).isPresent())
            repository.save(UserAdditional);
        else
            throw new Exception(UserAdditional.class.getName() +" class entity with id " + UserAdditional.getId() + " does not exist");
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, })
    public void setRoles(@NotNull Integer userId,@NotNull List<Integer> rolesId) throws Exception {
        List<ClubRole> roles = new ArrayList<>();
        if (rolesId.isEmpty()) throw new Exception("No roles to set");
        Optional<UserAdditional> User = repository.findById(userId);

        if (User.isEmpty()) throw new Exception("User with id " + userId + "not found");

        for(Integer id:rolesId)
        {
            Optional<ClubRole> role = ServiceC.GetByID(id);
            if(role.isPresent()) {
                roles.add(role.get());
                role.get().getUsersWithThisRole().add(User.get());
            }
            else throw new Exception("No such role with id " + id + "in database");

        }
        User.get().setRoles(roles);
    }


    @Transactional
    public PageModel<RatingDataModel> getRatingTable(Pageable pageable)
    {
        var page = getAll(pageable);
        List<UserAdditional> users = page.getContent();
        List<RatingDataModel> ratings = new ArrayList<>();
        for (UserAdditional user:users)
        {
            List<GameMember> members = user.getMembers();
            RatingDataModel model = new RatingDataModel();
            model.setNickname(user.getNickname());

            Integer gameCount = members.size();
            Integer wins = 0;
            Integer loses = 0;
            Float TEP = 0f;
            Float TPP = 0f;
            Float TCP = 0f;
            Integer T2B = 0;
            Integer T3B = 0;
            Integer T3R = 0;

            for (int i = 0; i < members.size();i++)
            {
                if (members.get(i).isWin())
                {
                    wins++;
                }
                else
                {
                    loses++;
                }
                TEP += members.get(i).getExtraPoints();
                TPP += members.get(i).getPenalty();
                TCP += members.get(i).getBM_Compensation();
                T2B += members.get(i).getBM_2Black();
                T3B += members.get(i).getBM_3Black();
                T3R += members.get(i).getBM_3Red();

            }
            Float totalP = TEP + TPP + TCP;
            model.setTotalPoints(totalP);
            model.setNumberCounts(wins+loses);
            model.setWins(wins);
            model.setLoses(loses);
            model.setTotalExtraPoints(TEP);
            model.setTotalPenaltyPoints(TPP);
            model.setTotalCompensationPoints(TCP);
            model.setTotal2B(T2B);
            model.setTotal3B(T3B);
            model.setTotal3R(T3R);
            ratings.add(model);

        }

        return new PageModel<>(ratings,page.getTotalPages());
    }


}
