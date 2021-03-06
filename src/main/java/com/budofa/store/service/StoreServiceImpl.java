package com.budofa.store.service;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.budofa.store.controler.model.AddressDTO;
import com.budofa.store.controler.model.StoreDTO;
import com.budofa.store.model.Address;
import com.budofa.store.model.Store;
import com.budofa.store.repository.StoreRepository;

@Service
public class StoreServiceImpl extends BaseServiceImpl<Store, StoreDTO, StoreRepository> implements StoreService {

    @Override
    public ModelMapper getMapper() {
	
	Converter<Address, AddressDTO> addressConverter = new AbstractConverter<Address, AddressDTO>() {
	    protected AddressDTO convert(Address source) {
		ModelMapper mapper = new ModelMapper();
		AddressDTO addressDTO = mapper.map(source, AddressDTO.class);
		return addressDTO;
	    }
	};

	ModelMapper mapper = new ModelMapper();
	mapper.addConverter(addressConverter);

	return mapper;
    }

}
