package com.ironbank.service;


import com.ironbank.ProfileConstants;
import com.ironbank.model.ProphetProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(ProfileConstants.ЗИМА_ТУТА)
public class WhiteListProphetService implements ProphetService {

  @Autowired
  private ProphetProperties prophetProperties;

  @Override
  public boolean willSurvive(String name) {
    return prophetProperties.getТеКтоВозвращаютДолги().contains(name);
  }
}
