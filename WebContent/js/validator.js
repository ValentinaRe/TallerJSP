$(document).ready(function() {
					
					$('#TallerServlet')
							.bootstrapValidator(
									{
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
										fields : {
											run : {
												validators : {
													notEmpty : {
														message : 'El run es requerido'
													},
													stringLength : {
														min : 9,
														message : 'El run debe contener mínimo 9 caracteres',
														max : 12,
														message : 'El run debe contener máximo 12 caracteres'
													}
												}
											},
											nombre : {
												validators : {
													notEmpty : {
														message : 'El nombre es requerido'
													},
													stringLength : {
														max : 50,
														message : 'El nombre debe contener maximo 50 caracteres'
													}
												}
											},
											apellido : {
												validators : {
													notEmpty : {
														message : 'El apellido es requerido'
													},
													stringLength : {
														max : 50,
														message : 'El apellido debe contener maximo 50 caracteres'
													}
												}
											},
											mail : {
												validators : {
													notEmpty : {
														message : 'El correo es requerido y no puede ser vacio'
													},
													emailAddress : {
														message : 'El correo electronico no es valido'
													},
													stringLength : {
														max : 50,
														message : 'El correo electronico debe contener maximo 50 caracteres'
													}
												}
											},
											telefono : {
												validators : {
													notEmpty : {
														message : 'El telefono es requerido'
													},
													stringLength : {
														max : 20,
														message : 'El telefono debe contener maximo 20 caracteres'
													},
													regexp : {
														regexp : /^[0-9]+$/,
														message : 'El teléfono solo puede contener números'
													}
												}
											},
											pais : {
												validators : {
													notEmpty : {
														message : 'El pais es requerido'
													},
													stringLength : {
														max : 20,
														message : 'El pais debe contener maximo 20 caracteres'
													}
												}
											},
											region : {
												validators : {
													notEmpty : {
														message : 'La region es requerida'
													},
													stringLength : {
														max : 20,
														message : 'La region debe contener maximo 20 caracteres'
													}
												}
											},
											ciudd : {
												validators : {
													notEmpty : {
														message : 'La ciudad es requerido'
													},
													stringLength : {
														max : 20,
														message : 'La ciudad debe contener maximo 20 caracteres'
													}
												}
											},

										}

									});
					$('#ActualizarServlet')
							.bootstrapValidator(
									{
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
										fields : {
											id : {
												validators : {
													notEmpty : {
														message : 'El id es requerido'
													},
													stringLength : {
														max : 20,
														message : 'El id debe contener maximo 20 caracteres'
													},
													regexp : {
														regexp : /^[0-9]+$/,
														message : 'El id solo puede contener números'
													}
												}
											},
											run : {
												validators : {
													notEmpty : {
														message : 'El run es requerido'
													},
													stringLength : {
														min : 12,
														message : 'El run debe contener mínimo 9 caracteres',
														max : 12,
														message : 'El run debe contener maximo 12 caracteres'
													}
												}
											},
											nombre : {
												validators : {
													notEmpty : {
														message : 'El nombre es requerido'
													},
													stringLength : {
														max : 50,
														message : 'El nombre debe contener maximo 50 caracteres'
													}
												}
											},
											apellido : {
												validators : {
													notEmpty : {
														message : 'El apellido es requerido'
													},
													stringLength : {
														max : 50,
														message : 'El apellido debe contener maximo 50 caracteres'
													}
												}
											},
											mail : {
												validators : {
													notEmpty : {
														message : 'El correo es requerido y no puede ser vacio'
													},
													emailAddress : {
														message : 'El correo electronico no es valido'
													},
													stringLength : {
														max : 50,
														message : 'El correo electronico debe contener maximo 50 caracteres'
													}
												}
											},
											telefono : {
												validators : {
													notEmpty : {
														message : 'El telefono es requerido'
													},
													stringLength : {
														max : 20,
														message : 'El telefono debe contener maximo 20 caracteres'
													},
													regexp : {
														regexp : /^[0-9]+$/,
														message : 'El teléfono solo puede contener números'
													}
												}
											},
											pais : {
												validators : {
													notEmpty : {
														message : 'El pais es requerido'
													},
													stringLength : {
														max : 20,
														message : 'El pais debe contener maximo 20 caracteres'
													}
												}
											},
											region : {
												validators : {
													notEmpty : {
														message : 'La region es requerida'
													},
													stringLength : {
														max : 20,
														message : 'La region debe contener maximo 20 caracteres'
													}
												}
											},
											ciudad : {
												validators : {
													notEmpty : {
														message : 'La ciudad es requerido'
													},
													stringLength : {
														max : 20,
														message : 'La ciudad debe contener maximo 20 caracteres'
													}
												}
											},

										}

									});

					$('#EliminarServlet')
							.bootstrapValidator(
									{
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
										fields : {
											id : {
												validators : {
													notEmpty : {
														message : 'El id es requerido'
													},
													stringLength : {
														max : 20,
														message : 'El id debe contener maximo 20 caracteres'
													},
													regexp : {
														regexp : /^[0-9]+$/,
														message : 'El id solo puede contener números'
													}
												}
											}
										}

									});
					$('#LoginServlet').bootstrapValidator({
				        feedbackIcons: {
				            valid: 'glyphicon glyphicon-ok',
				            invalid: 'glyphicon glyphicon-remove',
				            validating: 'glyphicon glyphicon-refresh'
				        },
				        fields: {
				            user: {
				                validators: {
				                    notEmpty: {
				                        message: 'El user es requerido'
				                    },
				                    stringLength: {
				                    	min : 9,
										message : 'El user debe contener mínimo 9 caracteres',
				                        max: 20,
				                        message: 'El user debe contener maximo 20 caracteres'
				                    }
				                }
				            },
				            password: {
				                validators: {
				                    notEmpty: {
				                        message: 'El password es requerido'
				                    },
				                    stringLength: {
				                    	min : 12,
										message : 'El password debe contener mínimo 12 caracteres',
				                        max: 20,
				                        message: 'El password debe contener maximo 20 caracteres'
				                    }
				                }
				            }
				        }
				   });
					$('#LoginUsuarioServlet').bootstrapValidator({
				        feedbackIcons: {
				            valid: 'glyphicon glyphicon-ok',
				            invalid: 'glyphicon glyphicon-remove',
				            validating: 'glyphicon glyphicon-refresh'
				        },
				        fields: {
				            user: {
				                validators: {
				                    notEmpty: {
				                        message: 'El user de usuario es requerido'
				                    },
				                    stringLength: {
				                    	min : 9,
										message : 'El user debe contener mínimo 9 caracteres',
				                        max: 20,
				                        message: 'El user  debe contener maximo 20 caracteres'
				                    }
				                }
				            },
				            password: {
				                validators: {
				                    notEmpty: {
				                        message: 'El password es requerido'
				                    },
				                    stringLength: {
				                    	min : 12,
										message : 'El password debe contener minimo 12 caracteres',
				                        max: 20,
				                        message: 'El password debe contener maximo 20 caracteres'
				                    }
				                }
				            }
				        }
				   });
					$('#IngresarUsuarioServlet')
					.bootstrapValidator(
							{
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									user : {
										validators : {
											notEmpty : {
												message : 'El user es requerido'
											},
											stringLength : {
												min : 9,
												message : 'El user debe contener minimo 9 caracteres',
												max : 100,
												message : 'El user debe contener maximo 20 caracteres'
											}
										}
									},
									password : {
										validators : {
											notEmpty : {
												message : 'El password es requerido'
											},
											stringLength : {
												min : 12,
												message : 'El password debe contener minimo 12 caracteres',
												max : 20,
												message : 'El password debe contener maximo 20 caracteres'
											}
										}
									
									

									}}

							});
					$('#ActualizarUsuarioServlet')
					.bootstrapValidator(
							{
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									id : {
										validators : {
											notEmpty : {
												message : 'El id es requerido'
											},
											stringLength : {
												max : 20,
												message : 'El id debe contener maximo 20 caracteres'
											},
											regexp : {
												regexp : /^[0-9]+$/,
												message : 'El id solo puede contener números'
											}
										}
									},
									user : {
										validators : {
											notEmpty : {
												message : 'El user es requerido'
											},
											stringLength : {
												min : 9,
												message : 'El user debe contener mínimo 9 caracteres',
												max : 20,
												message : 'El user debe contener maximo 20 caracteres'
											}
										}
									},
									password : {
										validators : {
											notEmpty : {
												message : 'El password  es requerido'
											},
											stringLength : {
												min : 12,
												message : 'El password debe contener mínimo 12 caracteres',
												max : 20,
												message : 'El password debe contener maximo 20 caracteres'
											}
										}
									}
								}

							});
					$('#EliminarUsuarioServlet')
					.bootstrapValidator(
							{
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									id : {
										validators : {
											notEmpty : {
												message : 'El id es requerido'
											},
											stringLength : {
												max : 20,
												message : 'El id debe contener maximo 20 caracteres'
											},
											regexp : {
												regexp : /^[0-9]+$/,
												message : 'El id solo puede contener números'
											}
										}
									}
								}

							});
					$('#IngresarEmpresaServlet')
					.bootstrapValidator(
							{
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									rut : {
										validators : {
											notEmpty : {
												message : 'El rut es requerido'
											},
											stringLength : {
												min : 12,
												message : 'El rut debe contener mínimo 9 caracteres',
												max : 12,
												message : 'El rut debe contener maximo 12 caracteres'
											}
										}
									},
									nombre : {
										validators : {
											notEmpty : {
												message : 'El nombre es requerido'
											},
											stringLength : {
												max : 50,
												message : 'El nombre debe contener maximo 50 caracteres'
											}
										}
									},
									ciudad : {
										validators : {
											notEmpty : {
												message : 'La ciudad es requerida'
											},
											stringLength : {
												max : 50,
												message : 'La ciudad debe contener maximo 50 caracteres'
											}
										}
									},
									
									direccion : {
										validators : {
											notEmpty : {
												message : 'La direccion es requerida'
											},
											stringLength : {
												max : 50,
												message : 'La ciudad debe contener maximo 50 caracteres'
											}
										}
									},
									pais : {
										validators : {
											notEmpty : {
												message : 'El pais es requerido'
											},
											stringLength : {
												max : 50,
												message : 'El pais debe contener maximo 50 caracteres'
											}
										}
									},
									telefono : {
										validators : {
											notEmpty : {
												message : 'El telefono es requerido'
											},
											stringLength : {
												max : 20,
												message : 'El telefono debe contener maximo 20 caracteres'
											},
											regexp : {
												regexp : /^[0-9]+$/,
												message : 'El teléfono solo puede contener números'
											}
										}
									},
									razonSocial : {
										validators : {
											notEmpty : {
												message : 'La razon social es requerido'
											},
											stringLength : {
												max : 50,
												message : 'La razon social debe contener maximo 50 caracteres'
											}
										}
									},
									
									
								}

							});
					
					$('#ActualizarEmpresaServlet')
					.bootstrapValidator(
							{
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									id : {
										validators : {
											notEmpty : {
												message : 'El id es requerido'
											},
											stringLength : {
												max : 20,
												message : 'El id debe contener maximo 20 caracteres'
											},
											regexp : {
												regexp : /^[0-9]+$/,
												message : 'El id solo puede contener números'
											}
										}
									},
									rut : {
										validators : {
											notEmpty : {
												message : 'El rut es requerido'
											},
											stringLength : {
												max : 9,
												message : 'El rut debe contener maximo 9 caracteres',
												max : 12,
												message : 'El rut debe contener maximo 12 caracteres'
											}
										}
									},
									nombre : {
										validators : {
											notEmpty : {
												message : 'El nombre es requerido'
											},
											stringLength : {
												max : 100,
												message : 'El nombre debe contener maximo 100 caracteres'
											}
										}
									},
									ciudad : {
										validators : {
											notEmpty : {
												message : 'La ciudad es requerida'
											},
											stringLength : {
												max : 50,
												message : 'La ciudad debe contener maximo 50 caracteres'
											}
										}
									},
									
									
								
									direccion : {
										validators : {
											notEmpty : {
												message : 'La direccion es requerido'
											},
											stringLength : {
												max : 50,
												message : 'La direccion debe contener maximo 50 caracteres'
											}
										}
									},
									pais : {
										validators : {
											notEmpty : {
												message : 'El pais es requerido'
											},
											stringLength : {
												max : 50,
												message : 'El pais debe contener maximo 50 caracteres'
											}
										}
									},	
									telefono : {
										validators : {
											notEmpty : {
												message : 'El telefono es requerido'
											},
											stringLength : {
												max : 20,
												message : 'El telefono debe contener maximo 20 caracteres'
											},
											regexp : {
												regexp : /^[0-9]+$/,
												message : 'El teléfono solo puede contener números'
											}
										}
									},
									razonSocial : {
										validators : {
											notEmpty : {
												message : 'La razon social es requerido'
											},
											stringLength : {
												max : 50,
												message : 'La razon social debe contener maximo 50 caracteres'
											}
										}
									},

								}

							});

			$('#EliminarEmpresaServlet')
					.bootstrapValidator(
							{
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									id : {
										validators : {
											notEmpty : {
												message : 'El id es requerido'
											},
											stringLength : {
												max : 20,
												message : 'El id debe contener maximo 20 caracteres'
											},
											regexp : {
												regexp : /^[0-9]+$/,
												message : 'El id solo puede contener números'
											}
										}
									}
								}

							});
					
				});