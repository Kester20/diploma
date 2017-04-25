package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Laptop;
import com.diploma.noormal.model.QLaptop;
import com.diploma.noormal.repository.LaptopRepository;
import com.diploma.noormal.service.LaptopService;
import com.diploma.noormal.service.ProducerService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static com.diploma.noormal.util.Constants.ASC;
import static com.diploma.noormal.util.Constants.CATEGORY_LIST;
import static com.diploma.noormal.util.Constants.COUNT_OF_LAPTOPS;
import static com.diploma.noormal.util.Constants.COUNT_OF_PAGES;
import static com.diploma.noormal.util.Constants.CURRENT_PAGE;
import static com.diploma.noormal.util.Constants.DEFAULT_FIRST_PRICE;
import static com.diploma.noormal.util.Constants.DEFAULT_PAGE;
import static com.diploma.noormal.util.Constants.DEFAULT_SECOND_PRICE;
import static com.diploma.noormal.util.Constants.DEFAULT_SELECT_SHOW;
import static com.diploma.noormal.util.Constants.DESC;
import static com.diploma.noormal.util.Constants.LAPTOPS_ID;
import static com.diploma.noormal.util.Constants.LAPTOP_LIST;
import static com.diploma.noormal.util.Constants.PRODUCER_LIST;
import static com.diploma.noormal.util.Constants.SHOW_COUNT;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class LaptopServiceImpl implements LaptopService {

    private LaptopRepository laptopRepository;
    private ProducerService producerService;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, ProducerService producerService) {
        this.laptopRepository = laptopRepository;
        this.producerService = producerService;
    }

    @Override
    public Laptop findOne(long idLaptop){
        return laptopRepository.findOne(idLaptop);
    }

    @Override
    public Page<Laptop> findLaptopsByCriteria(String[] producers, Integer firstPrice,
                                              Integer secondPrice, String orderBy, Integer showCount,
                                              Integer page, String orderMode, Model model) {

        firstPrice = firstPrice == null ? DEFAULT_FIRST_PRICE : firstPrice;
        secondPrice = secondPrice == null ? DEFAULT_SECOND_PRICE : secondPrice;
        orderBy = orderBy == null ? LAPTOPS_ID : orderBy;
        showCount = showCount == null ? DEFAULT_SELECT_SHOW : showCount;
        page = page == null ? DEFAULT_PAGE : page;
        orderMode = orderMode == null ? ASC : DESC;

        Predicate predicate = getPredicate(producers,firstPrice, secondPrice);
        Pageable pageable = getPageable(orderMode, orderBy, page, showCount);

        Page<Laptop> result = laptopRepository.findAll(predicate, pageable);
        prepareResponse(model, result, showCount, page);
        return result;
    }

    private Predicate getPredicate(String[] producers, Integer firstPrice, Integer secondPrice){
        QLaptop qLaptop = QLaptop.laptop;
        Predicate predicateProducer = producers == null ? null : qLaptop.producer.name.in(producers);
        return qLaptop.cost.between(firstPrice, secondPrice)
                .and(predicateProducer);
    }

    private Pageable getPageable(String orderMode, String orderBy, Integer page, Integer showCount){
        Sort sort = orderMode.contains(ASC) ? new Sort(Sort.Direction.ASC, orderBy) : new Sort(Sort.Direction.DESC, orderBy);
        return new PageRequest(page - 1, showCount, sort);
    }

    private void prepareResponse(Model model, Page<Laptop> laptops, Integer showCount, Integer currentPage) {
        model.addAttribute(LAPTOP_LIST, laptops.getContent());
        model.addAttribute(PRODUCER_LIST, producerService.getAllProducers());
        model.addAttribute(COUNT_OF_LAPTOPS, laptops.getTotalElements());
        model.addAttribute(COUNT_OF_PAGES, Math.ceil(laptops.getTotalElements()/showCount));
        model.addAttribute(SHOW_COUNT, showCount);
        model.addAttribute(CURRENT_PAGE, currentPage);
    }
}
